package com.doctor330.cloud.common;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * 公用常量类
 * 
 */
public abstract class Constants {

	/** 默认时间格式 **/
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	/** 手机客户端程序 **/
	public static final String DATE_TIME_MOBILE_FORMAT = "yyyyMMddHHmmss";
	/**
	 * 访问来源
	 */
	public static final String REQUEST_SOURCE = "mobile";
	/** Date默认时区 **/
	public static final String DATE_TIMEZONE = "GMT+8";

	/** UTF-8字符 **/
	public static final String CHARSET_UTF8 = "UTF-8";

	/** GBK字符 **/
	public static final String CHARSET_GBK = "GBK";

	/** JSON 应格 */
	public static final String FORMAT_JSON = "json";
	/** XML 应格 */
	public static final String FORMAT_XML = "xml";

	/** MD5签名方式 */
	public static final String SIGN_METHOD_MD5 = "md5";
	/** HMAC签名方式 */
	public static final String SIGN_METHOD_HMAC = "hmac";

	/** 正式环境授权相关地址 */
	// TODO public static final String PRODUCT_AUTHORIZE_URL = "http://**/";
	public static final String PRODUCT_CONTAINER_URL = "http://**";

	/** 沙箱环境授权相关地址 */
	// TODO public static final String SANDBOX_AUTHORIZE_URL = "**";
	public static final String SANDBOX_CONTAINER_URL = "http://**";

	/** SDK版本 */
	public static final String SDK_VERSION = "top-sdk-java-20110909";

	// ========================上传图片、附件======================
	public static String CONTEXT_PATH_BUSINESS_CARD;

	// ========================上传图片、附件==============================================
	static {
		CONTEXT_PATH_BUSINESS_CARD = "/app/web_site";
	}

	public static String CONTEXT_PATH;
	// public static String DOMAIN_NAME = "www.doctor330.com";

	static {
		try {
			CONTEXT_PATH = new File(Constants.class.getResource("/").toURI().getPath()).getParentFile().getParentFile()
					.getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	// public static final String UPLOAD_IMGE_FILE_PATH = "/upload/images/";//
	// 图片上传的根路径
	public static final Integer BIGE_IMGE_FILE_SIZE = 800;// 大图的宽度
	public static final Integer CENTER_IMGE_FILE_SIZE = 600;// 中图的宽度
	public static final Integer SMALL_IMGE_FILE_SIZE = 400;// 小图的宽度

	// public static final String UPLOAD_OTHER_FILE_PATH = "/upload/file/";//
	// 图片上传的根路径

	// public static final String UPLOAD_PROJECT_IMG_PATH =
	// "/app/web_site/images/temp/";// 项目图片上传的临时路径

	// ========================上传图片========================

	// ------------------------发布状态 ------------------------

	// 0是保存（即新建、未审核），1提交审核（待审核、审核中），2审核通过（即已发布），3审核未通过， 4用户点击下线， 5到期下线（项目到期）
	// ，6已删除，7已停用（管理员强制停用）
	public static final Integer PUBLISH_STATE_CREATE_NOCHECK = 0;
	public static final Integer PUBLISH_STATE_SUBMIT_CHECKING = 1;
	public static final Integer PUBLISH_STATE_CHECK_PASS = 2;
	public static final Integer PUBLISH_STATE_CHECK_NOPASS = 3;
	public static final Integer PUBLISH_STATE_CLICK_UNSHELVE = 4;
	public static final Integer PUBLISH_STATE_OUTDATE_UNSHELVE = 5;
	public static final Integer PUBLISH_STATE_DELETE = 6;
	public static final Integer PUBLISH_STATE_STOP = 7;

	// ------------------------发布状态 ------------------------

	// ==========================首页=========================
	public static final Integer INDEX_BANNER_TYPE_WEB = 0;
	public static final Integer INDEX_BANNER_TYPE_WAP = 1;
	public static final Integer INDEX_BANNER_TYPE_IOS = 2;
	public static final Integer INDEX_BANNER_TYPE_ANDROID = 3;
	public static final Integer INDEX_BANNER_TYPE_PAD = 4;
	// ==========================首页==========================

	// ------------------------banner图显示位置------------------
	public static final Integer BANNER_SHOW_POSITION_INDEX = 0;
	public static final Integer BANNER_SHOW_POSITION_PROJECT = 1;
	public static final Integer BANNER_SHOW_POSITION_DEMAND = 2;
	public static final Integer BANNER_SHOW_POSITION_SERVICE = 3;
	public static final Integer BANNER_SHOW_POSITION_ROADSHOW = 4;
	// ------------------------banner图显示位置---------------------

	// ==========================黑名单状态========================
	public static final Integer FRIEND_IS_BLACK = 1;
	public static final Integer FRIEND_IS_NOT_BLACK = 0;
	// ==========================黑名单状态========================

	// ------------------------洽谈------------------------
	public static final Integer TALKER_RECEIVE = 1;
	public static final Integer TALKER_APPLY = 2;
	// ------------------------洽谈------------------------

	// ==========================申请加好友==================
	public static final Integer ADD_FRIEND_NO_CHECK = 0;
	public static final Integer ADD_FRIEND_AGREE = 1;
	public static final Integer ADD_FRIEND_DISAGREE = 2;
	// ==========================申请加好友===================

	// ------------------------好友设置------------------------
	public static final Integer FRIEND_RECEIVE_MESSAGE = 0x0001;
	public static final Integer FRIEND_NO_RECEIVE_MESSAGE = 0x0000;
	public static final Integer FRIEND_RECEIVE_ITEM = 0x0002;
	public static final Integer FRIEND_NO_RECEIVE_ITEM = 0x0000;
	// ------------------------好友设置------------------------

	// ==========================投递==========================
	public static final Integer DELIVER_APPLY_DEMAND = 1;
	public static final Integer DELIVER_RECEIVE_PROJECT = 2;
	// ==========================好友设置=======================

	// ------------------------好友删除------------------------
	public static final Integer FRIEND_IS_NOT_DELETE = 0;
	public static final Integer FRIEND_IS_DELETE = 1;
	// ------------------------好友删除------------------------
	// ==========================好友群组删除=====================
	public static final Integer FRIEND_GROUP_IS_NOT_DELETE = 0;
	public static final Integer FRIEND_GROUP_IS_DELETE = 1;
	// ==========================好友群组删除=====================
	// ------------------------项目归属------------------------
	public static final Integer BELONG_NO_FRIEND = 0;
	public static final Integer BELONG_FRIEND = 1;
	public static final Integer BELONG_MY = 2;
	// ------------------------项目归属------------------------
	// ==========================用户是否认证====================，1已认证；默认0,2:联合登陆废弃,3:认证失败4:环信注册失败废弃，5:认证中
	/** 0 未认证 */
	public static final Integer USER_IFAUTHER_NO = 0;
	/** 1 已认证 */
	public static final Integer USER_IFAUTHER_ALREADY = 1;
	/** 2:联合登陆废弃 */
	public static final Integer USER_IFAUTHER_DISCARD = 2;
	/** 3:认证失败 */
	public static final Integer USER_IFAUTHER_AUTHERFAIL = 3;
	/** 4:环信注册失败废弃 */
	public static final Integer USER_IFAUTHER_UUIDFAIL = 4;
	/** 5:认证中 */
	public static final Integer USER_IFAUTHER_KEEPING = 5;
	// ==========================用户是否认证=====================

	// ------------------------图片路径------------------------
	// public static final String PICTURE_WEB_SITE_P1 = "http://p1.doctor330.com";
	// public static final String PICTURE_WEB_SITE_P2 = "http://p2.doctor330.com";
	// public static final String PICTURE_WEB_SITE_P3 = "http://p3.doctor330.com";
	// public static final String PICTURE_TEMP_URL = "/app/web_site";

	// ------------------------图片路径------------------------

	// ==========================申请洽谈的操作状态================
	public static final Integer APPLYSTATUS_NO_APPLY = 0;
	public static final Integer APPLYSTATUS_COMPLETE_APPLY = 1;
	public static final Integer APPLYSTATUS_REFUSE_APPLY = 2;
	public static final Integer APPLYSTATUS_AGREE_APPLY = 3;
	// ==========================申请洽谈的操作状态================

	// ------------------------数据初始值------------------------
	public static final Integer USERID = 100000000;
	// ------------------------数据初始值------------------------

	// ==========================操作==========================
	public static final Integer OPERATION_ADD = 0;
	public static final Integer OPERATION_DELTET = 1;
	// ==========================操作==========================

	// ------------------------APP消息推送 接收到的消息类型------------
	public static final Integer MESSAGETYPE_SYSTEMMSSAGE = 0; // 系统消息
	public static final Integer MESSAGETYPE_APPLY_FRIEND = 1; // 好友申请消息
	public static final Integer MESSAGETYPE_APPLY_FRIEND_AGREE = 2; // 好友申请同意消息
	public static final Integer MESSAGETYPE_APPLY_TALK = 3; // 申请洽谈消息
	public static final Integer MESSAGETYPE_APPLY_TALK_AGREE = 4; // 申请洽谈同意消息
	public static final Integer MESSAGETYPE_SUBMIT_PROJECT = 5; // 投递项目消息
	public static final Integer MESSAGETYPE_SUBMIT_PROJECT_AGREE = 6; // 投递项目匹配消息
	public static final Integer MESSAGETYPE_LEAVE = 7; //留言消息
	public static final Integer MESSAGETYPE_PRIVATE_LETTER = 8; // 私信消息

	// ------------------------APP消息推送 接收到的消息类型-------------

	// ==========================短信类型==========================
	/*
	 * 短信类型 0 系统短信 1 验证码短信
	 */
	public static final int SMS_TYPE_SYSTEM = 0;
	public static final int SMS_TYPE_VERIFICATION = 1;
	// ==========================短信类型==========================

	// ------------------------消息是否已读的状态------------------------
	public static final Integer MESSAGE_UNREAD = 0;
	public static final Integer MESSAGE_READ = 1;
	// ------------------------消息是否已读的状态------------------------

	// ==========================短信类型==========================
	public static final int MESSAGE_REPLY_UPPER_LIMIT = 3;
	// ==========================短信类型==========================

	// ------------------------用户属性配置------------------------
	public static final Integer USER_CONFIG_NAME_OPEN_SET = 1;
	public static final Integer USER_CONFIG_COMPANY_OPEN_SET = 2;
	public static final Integer USER_CONFIG_PROJECT_DEAL_REMIND = 3;
	public static final Integer USER_CONFIG_APPLY_TALKER_REMIND = 4;
	public static final Integer USER_CONFIG_FRIEND_APPLY_REMIND = 5;
	public static final Integer USER_CONFIG_FRIEND_CHAT_REMIND = 6;
	// ------------------------用户属性配置------------------------

	// ==========================APPkey==========================
	/**
	 * android的appkey
	 */
	// public static final String SECURITY_ANDROID_APPKEY =
	// "B0F64E568E3BCB933CD82C66A9B1D56D ";
	/**
	 * ios的appkey
	 */
	// public static final String SECURITY_IOS_APPKEY =
	// "6BF27FD52B952D42A5CDDB554C2E4E34";
	// ==========================APPkey==========================

	// ------------------------APP更新规则------------------------
	/** 当前已是最新版本 */
	public static final Integer APP_NO_UPDATE = 0;
	/** 发现新版本，是否更新（可选项更新）； */
	public static final Integer APP_WEAK_UPDATE = 1;
	/** 您的版本过老，请更新到V2.0; (即强制更新) */
	public static final Integer APP_STRONG_UPDATE = 2;
	// ------------------------APP更新规则------------------------

	// ==========================头像==========================
	/**
	 * 默认头像
	 */
	// public static final String HEADPIC_DEFAULT =
	// "http://p1.doctor330.com/images/default-tx.png ";

	// ==========================头像==========================

	// ==========================企业审核状态==========================
	/** 企业审核状态: 审核中 */
	public static final Integer COMPANY_CHECK_STATUS_KEEPING = 0;
	/** 企业审核状态 : 审核未通过 */
	public static final Integer COMPANY_CHECK_STATUS_NOPASS = 1;
	/** 企业审核状态: 审核通过 */
	public static final Integer COMPANY_CHECK_STATUS_PASS = 2;
	// ==========================企业审核状态==========================

	// ------------------------检测用户关联企业的状态-----------------------
	/** 名片未认证 */
	public static final Integer CHECK_COMPANY_STATUS_BUSINESSCARD_NO_AUTH = 0;
	/** 企业未认证 */
	public static final Integer CHECK_COMPANY_STATUS_COMPANY_NO_AUTH = 1;
	/** 企业认证中 */
	public static final Integer CHECK_COMPANY_STATUS_COMPANY_KEEPING = 2;
	/** 企业认证失败 */
	public static final Integer CHECK_COMPANY_STATUS_COMPANY_NO_PASS = 3;
	/** 企业未关联 */
	public static final Integer CHECK_COMPANY_STATUS_COMPANY_NO_RELATION = 4;
	/** 企业已关联 */
	public static final Integer CHECK_COMPANY_STATUS_COMPANY_ALREADY_RELATION = 5;
	/** 名片认证中 */
	public static final Integer CHECK_COMPANY_STATUS_BUSINESSCARD_KEEPING = 6;
	/** 名片认证失败 */
	public static final Integer CHECK_COMPANY_STATUS_BUSINESSCARD_FAIL_AUTH = 7;
	// ------------------------检测用户关联企业的状态-----------------------

	// ==========================获取企业认证信息状态==========================
	/**名片未认证*/
	public static final Integer COMPANY_INFORMATION_STATUS_BUSINESSCARD_NO_AUTH = 0;
	/**名片认证失败*/
	public static final Integer COMPANY_INFORMATION_STATUS_BUSINESSCARD_FAIL_AUTH = 1;
	/**名片认证中*/
	public static final Integer COMPANY_INFORMATION_STATUS_BUSINESSCARD_KEEPING_AUTH = 2;
	/**企业未认证*/
	public static final Integer COMPANY_INFORMATION_STATUS_COMPANY_NO_AUTH = 3;
	/**企业已认证（认证通过），面向企业上传者*/
	public static final Integer COMPANY_INFORMATION_STATUS_COMPANY_AUTH_PASS_TO_UPLOADER = 4;
	/**企业已认证（认证通过），面向普通成员，该普通成员已关联企业*/
	public static final Integer COMPANY_INFORMATION_STATUS_COMPANY_AUTH_PASS_TO_NO_UPLOADER_RELATE_COMPANY = 5;
	/**企业已认证（认证通过），面向普通成员，该普通成员没有关联企业*/
	public static final Integer COMPANY_INFORMATION_STATUS_COMPANY_AUTH_PASS_TO_NO_UPLOADER_NO＿RELATE_COMPANY = 6;
	/**企业认证审核中，面向企业上传者*/
	public static final Integer COMPANY_INFORMATION_STATUS_COMPANY_AUTH_KEEPING_TO_UPLOADER = 7;
	/**企业认证审核中，面向普通成员*/
	public static final Integer COMPANY_INFORMATION_STATUS_COMPANY_AUTH_KEEPING_TO_NO_UPLOADER = 8;
	/**企业认证未通过，面向企业上传者*/
	public static final Integer COMPANY_INFORMATION_STATUS_COMPANY_AUTH_FAIL_TO_UPLOADER = 9;
	/**企业认证未通过，面向普通成员*/
	public static final Integer COMPANY_INFORMATION_STATUS_COMPANY_AUTH_FAIL_TO_NO_UPLOADER = 10;
	// ==========================获取企业认证信息状态==========================

}
