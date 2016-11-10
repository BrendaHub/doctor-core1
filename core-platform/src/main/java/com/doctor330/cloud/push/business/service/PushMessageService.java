package com.doctor330.cloud.push.business.service;

import com.doctor330.cloud.push.common.Constants;
import com.doctor330.cloud.push.vo.Notification;
import com.doctor330.cloud.push.vo.PushResult;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.base.payload.APNPayload;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.TransmissionTemplate;

/**
 * @author 郑源
 * @date 创建时间：2016年2月25日 下午7:35:52
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public class PushMessageService{

	/**
	 * 推送透传消息给单个安卓用户
	 * @param CID
	 * @param transmissionContent
	 * @param transmissionType
	 * @param offlineExpireTime
	 * @return
	 */
	@SuppressWarnings("finally")
	public PushResult pushTransmissionToSingleUserForAndroid(String CID, String transmissionContent ,Integer transmissionType,Integer offlineExpireTime) {
		
		String host =null;
		IGtPush push = new IGtPush(host, Constants.APPKEY, Constants.MASTERSECRET);
		TransmissionTemplate template = new TransmissionTemplate();
		template.setAppId(Constants.APPID);
		template.setAppkey(Constants.APPKEY);
		template.setTransmissionContent(transmissionContent);
		template.setTransmissionType(2);
		SingleMessage message = new SingleMessage();
		message.setOffline(true);
		// 离线有效时间，单位为毫秒，可选
		message.setOfflineExpireTime(offlineExpireTime==null ? 24 * 1000 * 3600 : offlineExpireTime);
		message.setData(template);
		message.setPushNetWorkType(0); // 可选。判断是否客户端是否wifi环境下推送，1为在WIFI环境下，0为不限制网络环境。
		Target target = new Target();
		target.setAppId(Constants.APPID);
		target.setClientId(CID);
		IPushResult ret = null;
		PushResult pushResult = new PushResult();
		try {
			ret = push.pushMessageToSingle(message, target);
			
		} catch (RequestException e) {
			e.printStackTrace();
			ret = push.pushMessageToSingle(message, target, e.getRequestId());

		}
		finally{
			String taskId = (String) ret.getResponse().get("taskId");
			String result = (String) ret.getResponse().get("result");
			String status = (String) ret.getResponse().get("status");
			if(result != null&&!"".equals(result))
				pushResult.setResult(result);
			if(taskId != null&&!"".equals(taskId))
				pushResult.setTaskId(taskId);
			if(status != null&&!"".equals(taskId))
				pushResult.setStatus(status);
			return pushResult;
		}
		
	}
	/**
	 * 推送透传消息给单个IOS用户
	 * @param CID
	 * @param transmissionContent
	 * @param transmissionType
	 * @param offlineExpireTime
	 * @return
	 */
	@SuppressWarnings("finally")
	public PushResult pushTransmissionToSingleUserForIOS(String CID, String transmissionContent ,Integer transmissionType,Integer offlineExpireTime) {
		
		String host =null;
		IGtPush push = new IGtPush(host, Constants.APPKEY, Constants.MASTERSECRET);
		
		TransmissionTemplate template = new TransmissionTemplate();
		template.setAppId(Constants.APPID);
		template.setAppkey(Constants.APPKEY);
		template.setTransmissionContent(transmissionContent);
		template.setTransmissionType(2);
		
		//ios的通知
	    APNPayload payload = new APNPayload();
	    payload.setContentAvailable(1);
	    payload.setSound("default");
	    payload.setAlertMsg(new APNPayload.SimpleAlertMsg("并购网络给您发了一条新消息，请查看详情！"));
	    //字典模式使用下者
	    //payload.setAlertMsg(getDictionaryAlertMsg());
	    template.setAPNInfo(payload);


		SingleMessage message = new SingleMessage();
		message.setOffline(true);
		// 离线有效时间，单位为毫秒，可选
		message.setOfflineExpireTime(offlineExpireTime==null ? 24 * 1000 * 3600 : offlineExpireTime);
		message.setData(template);
		message.setPushNetWorkType(0); // 可选。判断是否客户端是否wifi环境下推送，1为在WIFI环境下，0为不限制网络环境。
		Target target = new Target();
		target.setAppId(Constants.APPID);
		target.setClientId(CID);
		IPushResult ret = null;
		PushResult pushResult = new PushResult();
		try {
			ret = push.pushMessageToSingle(message, target);
			
		} catch (RequestException e) {
			e.printStackTrace();
			ret = push.pushMessageToSingle(message, target, e.getRequestId());

		}
		finally{
			String taskId = (String) ret.getResponse().get("taskId");
			String result = (String) ret.getResponse().get("result");
			String status = (String) ret.getResponse().get("status");
			if(result != null&&!"".equals(result))
				pushResult.setResult(result);
			if(taskId != null&&!"".equals(taskId))
				pushResult.setTaskId(taskId);
			if(status != null&&!"".equals(taskId))
				pushResult.setStatus(status);
			return pushResult;
		}
		
	}
	
	/**
	 * 推送通知给单个安卓用户
	 * @param CID
	 * @param notification
	 * @param host
	 * @return
	 */
	@SuppressWarnings({ "finally"})
	public PushResult pushMessageToSingleUser(String CID, Notification notification, String host) {
		IGtPush push = new IGtPush(host, Constants.APPKEY, Constants.MASTERSECRET);
		NotificationTemplate template = new NotificationTemplate();

		template.setAppId(Constants.APPID);
		template.setAppkey(Constants.APPKEY);
		template.setTitle(notification.getTitle());
		template.setText(notification.getText());
		if(notification.getLogo() != null&&!"".equals(notification.getLogo()))
			template.setLogo(notification.getLogo());
		else{
			template.setLogo(Constants.LOG_URL);
		}
		if(notification.getIsRing() != null&&!"".equals(notification.getIsRing()))
			template.setIsRing(notification.getIsRing());
		if(notification.getIsVibrate() != null&&!"".equals(notification.getIsVibrate()))
			template.setIsVibrate(notification.getIsVibrate());
		if(notification.getIsClearable() != null&&!"".equals(notification.getIsClearable()))
			template.setIsClearable(notification.getIsClearable());
		
		if(notification.getTransmissionType() != null&&!"".equals(notification.getTransmissionType()))
			template.setTransmissionType(2);
		else{
			template.setTransmissionType(2);
		}
		if(notification.getTransmissionContent() != null&&!"".equals(notification.getTransmissionContent()))
			template.setTransmissionContent(notification.getTransmissionContent());
		if(notification.getLogoUrl() != null&&!"".equals(notification.getLogoUrl()))
			template.setLogoUrl(notification.getLogoUrl());
		else{
			template.setLogoUrl(Constants.LOG_URL);
		}

		SingleMessage message = new SingleMessage();
		message.setOffline(true);
		// 离线有效时间，单位为毫秒，可选
		message.setOfflineExpireTime(24 * 3600 * 1000);
		message.setData(template);
		message.setPushNetWorkType(0); // 可选。判断是否客户端是否wifi环境下推送，1为在WIFI环境下，0为不限制网络环境。
		Target target = new Target();
		target.setAppId(Constants.APPID);
		target.setClientId(CID);
		IPushResult ret = null;
		PushResult pushResult = new PushResult();
		try {
			ret = push.pushMessageToSingle(message, target);
			
		} catch (RequestException e) {
			e.printStackTrace();
			ret = push.pushMessageToSingle(message, target, e.getRequestId());

		}
		finally{
			String taskId = (String) ret.getResponse().get("taskId");
			String result = (String) ret.getResponse().get("result");
			String status = (String) ret.getResponse().get("status");
			if(result != null&&!"".equals(result))
				pushResult.setResult(result);
			if(taskId != null&&!"".equals(taskId))
				pushResult.setTaskId(taskId);
			if(status != null&&!"".equals(taskId))
				pushResult.setStatus(status);
			return pushResult;
		}
		
	}

}
