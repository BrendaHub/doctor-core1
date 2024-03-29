package com.doctor330.cloud.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doctor330.cloud.common.Constants;
import com.doctor330.cloud.config.ActionMapping;
import com.doctor330.cloud.interceptor.Interceptor;
import com.doctor330.cloud.utils.JSONActionWrite;
import com.doctor330.cloud.utils.XMLCheckFieldsWriter;

public class DefaultActionInvocation implements ActionInvocation {
	private Iterator<Interceptor> interceptors;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private ActionMapping actionMapping;
	private ApiActionInterfaces action;

	public DefaultActionInvocation(HttpServletRequest request, HttpServletResponse response,
			ActionMapping actionMapping) {
		this.request = request;
		this.response = response;
		this.actionMapping = actionMapping;
		interceptors = actionMapping.getIntercetors().iterator();

		action = Container.factory.buildAction(actionMapping);

		action.setRequest(request);
		action.setResponse(response);
	}

	public void setAction(ApiActionInterfaces action) {
		this.action = action;
	}

	public ApiActionInterfaces getAction() {
		return action;
	}

	public void invoke() {
		try {
			if (interceptors.hasNext()) {
				interceptors.next().intercept(DefaultActionInvocation.this);
			} else {
				action.execute();
				//write();
				mobileWrite();

			}
		} catch (Exception e) {
			e.printStackTrace();
			action.setMsg(e.getMessage());
			action.setDescription(e.getMessage());
			action.setIssuccessful(false);
			action.setStatuscode(500);
			//write();
			mobileWrite();

		}
	}

	private void mobileWrite() {
		StringBuffer sb = new StringBuffer();
		sb.append("{\"");
		sb.append("isSuccessful\":\"").append(action.isIssuccessful()).append("\",");
		sb.append("\"statusCode\":\"").append(action.getStatuscode()).append("\",");
		sb.append("\"description\":\"").append(action.getDescription()).append("\",");
		sb.append("\"desc\":\"").append(action.getDescription()).append("\",");
		sb.append("\"userId\":\"").append(action.getUserId()).append("\",");
		sb.append("\"data\":").append(new JSONActionWrite(action.getFields()).mobileWrite(action, true));
		sb.append("}");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		try {
			PrintWriter out = response.getWriter();
			out.write(sb.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void write() {
		if (Constants.FORMAT_JSON.equals(action.getFormat())) {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/plain");
			try {
				PrintWriter out = response.getWriter();
				out.write(getActionJSON());
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else if (Constants.FORMAT_XML.equals(action.getFormat())) {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/xml");
			try {
				PrintWriter out = response.getWriter();
				out.write(getActionXML());
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private String getActionJSON() {
		StringBuffer sb = new StringBuffer();
		if (action.getResponseName() != null) {
			sb.append("{\"");
			sb.append(action.getResponseName());
			sb.append("\":");
		}
		sb.append(new JSONActionWrite(action.getFields()).write(action));
		sb.append("}");

		return sb.toString();
	}

	private String getActionXML() {
		return new XMLCheckFieldsWriter(action.getFields()).write(action.getResponseName(), action);
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public ActionMapping getActionMapping() {
		return actionMapping;
	}

}