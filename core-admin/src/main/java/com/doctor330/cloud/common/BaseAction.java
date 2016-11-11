package com.doctor330.cloud.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.doctor330.cloud.util.json.JSONWriter;
import com.doctor330.common.utils.Doctor330JsonObject;

/**
 * 所有ACTION的基类
 *
 * @version $Revision$
 *
 */
public abstract class BaseAction {

	public static final int MAX_PAGE_SIZE = 100;
	public static final int REGISTER_NOT = 0;
	public static final int REGISTER_YES = 1;
	public static final int REGISTER_NOT_SURE = 2;

	public HttpServletRequest request;
	public HttpServletResponse response;

	protected String format;

	private String venderId;

	protected String token;

	public void setFormat(String format) {
		this.format = format;
	}

	public String getVenderId() {
		return venderId;
	}

	public void setVenderId(String venderId) {
		this.venderId = venderId;
	}

	/**
	 * 封装返回的JSON数据
	 * 
	 * @param desc
	 *            状态描述
	 * @param statusCode
	 *            状态码
	 * @param isSuccess
	 *            是否成功
	 * @param userId
	 *            用户ID
	 * @param data
	 *            数据
	 * @return
	 */
	public String getdoctor330JsonObject(String desc, Integer statusCode, Boolean isSuccess, Integer userId,
			Object data) {

		JSONWriter bgJson = new JSONWriter();
		Doctor330JsonObject doctor330JsonObject = new Doctor330JsonObject();
		if (desc != null && !"".equals(desc)) {
			doctor330JsonObject.setDesc(desc);
		}
		if (statusCode != null) {
			doctor330JsonObject.setStatusCode(statusCode);
		}
		if (isSuccess != null) {
			doctor330JsonObject.setIsSuccess(isSuccess);
		}
		if (userId != null) {
			doctor330JsonObject.setUserId(userId);
		}
		if (data != null) {
			doctor330JsonObject.setData(data);
		}
		
		return bgJson.write(doctor330JsonObject);
	}

	/**
	 * 获取截至日期
	 * 
	 * @param deadLine
	 * @return
	 */
	protected Date getDeadTime(Integer deadLine) {

		Calendar cc = Calendar.getInstance();
		cc.setTime(new Date());
		cc.add(Calendar.DAY_OF_MONTH, deadLine);
		Date newDeadTime = null;
		try {
			newDeadTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(cc.get(Calendar.YEAR) + "-"
					+ (cc.get(Calendar.MONTH) + 1) + "-" + cc.get(Calendar.DATE) + " 23:59:59");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return newDeadTime;
	}

	/**
	 * 随机生成用户名
	 * 
	 * @return
	 */
	public String getUserName() {
		return "ybg_" + (int) ((Math.random() * 9 + 1) * 100000);
	}

	/**
	 * 得到HttpRequest
	 * 
	 * @return 获得的HttpRequest
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * 得到HttpSession
	 * 
	 * @return 获得的HttpSession
	 */
	public HttpSession getSession() {
		return getRequest().getSession();
	}

	/**
	 * 得到HttpResponse
	 * 
	 * @return 获得的HttpResponse
	 */
	public HttpServletResponse getResponse() {
		return response;
	}

	/**
	 * 得到上下文路径，例如：/mylearningii
	 * 
	 * @return 上下文路径
	 */
	public String getContext() {
		return getRequest().getContextPath();
	}

	/**
	 * 得到服务全路径，例如：http://127.0.0.1:8080/mylearningii
	 * 
	 * @return 服务全路径
	 */
	public String getBasePath() {
		String path = getRequest().getContextPath();
		String basePath = getRequest().getScheme() + "://" + getRequest().getServerName();

		if (getRequest().getServerPort() != 80) {
			basePath += ":" + getRequest().getServerPort() + path;
		} else {
			basePath += path;
		}

		return basePath;
	}

	/**
	 * 验证手机号的有效性
	 * 
	 * @param mobile
	 * @return
	 */
	public boolean validateMobile(String mobile) {
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[0-9]))\\d{8}$");
		Matcher m = p.matcher(mobile);
		return m.matches();
	}

	/**
	 * 得到应用的绝对地址，例如：D:\Eclipse\workspace\CourseCreater\web\
	 * 
	 * @return 应用的绝对地址
	 */
	public String getRealPath() {
		return getRequest().getSession().getServletContext().getRealPath("/");
	}

	/**
	 * 获得用户的真实IP
	 * 
	 * @return 用户的真实IP
	 */
	public String getRealIP() {
		String ip = getRequest().getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = getRequest().getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = getRequest().getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = getRequest().getRemoteAddr();
		}

		return ip;
	}

	/**
	 * 获得请求的referer
	 * 
	 * @return referer
	 */
	public String getReferer() {
		String referer = getRequest().getHeader("referer");
		if (referer != null && !referer.equalsIgnoreCase("")) {
			referer = referer.substring(0, referer.lastIndexOf("/") + 1);
		} else {
			referer = "";
		}

		return referer;
	}

}
