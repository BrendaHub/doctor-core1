package com.doctor330.cloud.server.message;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.JSONObject;
import com.doctor330.cloud.modules.push.entity.BgUserPush;
import com.doctor330.cloud.modules.push.service.BgUserPushService;
import com.doctor330.cloud.push.business.service.PushMessageService;
import com.doctor330.cloud.push.common.Constants;
import com.doctor330.cloud.push.vo.Notification;
import com.doctor330.cloud.server.common.IRedisService;

/**
 * @author  郑源
 * @date 创建时间：2016年10月31日 下午19:52:48 
 * @version 2.0 
 * @parameter  
 * @since  
 * @return 
 */
@Service(value= "messageService")
public class MessageServiceImpl implements IMessageService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6796470067426644610L;
	
	@Autowired
	IRedisService redisService;
	@Autowired
	BgUserPushService bgUserPushService;
	
	@Override
	public Boolean pushMessageToSingleUser(Integer userId, String transmissionContent, Integer transmissionType,
			Integer offlineExpireTime) {
		
		if(userId ==null || transmissionContent==null || transmissionContent==null || transmissionType==null){
			return false;
		}
		
		List<BgUserPush> messagePushList = new ArrayList<BgUserPush>();
		try {
			PushMessageService pushMessageService = new PushMessageService();
			BgUserPush queryUserPushRecord = new BgUserPush();
			queryUserPushRecord.setUserid(userId.toString());
			messagePushList = bgUserPushService.findList(queryUserPushRecord);
			
			JSONObject transmissionContentObj = (JSONObject) JSON.parse(transmissionContent);
			if(messagePushList==null||messagePushList.size()<1){
				return false;
			}
			for (BgUserPush messagePush : messagePushList) {
				System.out.println("-------------------------"+messagePush.getClientid()+"-------------------------");
				String osType = messagePush.getOstype();
				if("android".equalsIgnoreCase(osType)){
					Notification notification = new Notification();
					notification.setTitle("并购网络给您发了一条新消息，请查看详情！");
					notification.setText("并购网络给您发了一条新消息，请查看详情！");
					notification.setLogo(Constants.LOG_URL);
					notification.setLogoUrl(Constants.LOG_URL);
					notification.setIsRing(true);
					notification.setIsVibrate(true);
					notification.setTransmissionContent("notification"+transmissionContentObj.get("messageType"));
					notification.setTransmissionType(transmissionType==null ? Constants.DEFAULT_TRANSMISSIONTYPE : transmissionType);
					pushMessageService.pushMessageToSingleUser(messagePush.getClientid(), notification, null);
					pushMessageService.pushTransmissionToSingleUserForAndroid(messagePush.getClientid(),transmissionContentObj.get("messageType")+"", transmissionType==null ? Constants.DEFAULT_TRANSMISSIONTYPE : transmissionType, offlineExpireTime);
				}
				else{
					pushMessageService.pushTransmissionToSingleUserForIOS(messagePush.getClientid(),transmissionContentObj.get("messageType")+"", transmissionType==null ? Constants.DEFAULT_TRANSMISSIONTYPE : transmissionType, offlineExpireTime);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
