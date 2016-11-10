package com.doctor330.cloud.push.vo;

import java.io.Serializable;

/**
 * @author  郑源
 * @date 创建时间：2016年3月1日 上午10:50:15 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return 
 */
public class NotyPopLoad implements Serializable {

	/**
	 * 长度：40中/英字符
	 * 必填：是
	 * 默认值：
	 * 说明:通知栏图标
	 */
	private String notyIcon;
	
	/**
	 * 长度：600中/英字符
	 * 必填：是
	 * 默认值：
	 * 说明:通知栏内容
	 */
	private String notyContent;
	
	/**
	 * 长度：40中/英字符
	 * 必填：是
	 * 默认值：
	 * 说明:弹出框标题
	 */
	private String notyTitle;
	private String popTitle;
	
	/**
	 * 长度：600中/英字符
	 * 必填：是
	 * 默认值：
	 * 说明:弹出框内容
	 */
	private String popContent;
	
	/**
	 * 长度：200中/英字符
	 * 必填：是
	 * 默认值：
	 * 说明:弹出框图标
	 */
	private String popImage;
	
	/**
	 * 长度：40中/英字符
	 * 必填：是
	 * 默认值：
	 * 说明:下载图标
	 */
	private String loadIcon;
	
	/**
	 * 长度：40中/英字符
	 * 必填：是
	 * 默认值：
	 * 说明:下载标题
	 */
	private String loadTitle;
	
	/**
	 * 长度：200中/英字符
	 * 必填：是
	 * 默认值：
	 * 说明:下载地址
	 */
	private String loadUrl;

	/**
	 * 长度：
	 * 必填：否
	 * 默认值：True
	 * 说明:通知栏是否可以清除
	 */
	private Boolean cleared;
	/**
	 * 长度：
	 * 必填：否
	 * 默认值：True
	 * 说明:是否响铃
	 */
	private Boolean belled;
	/**
	 * 长度：
	 * 必填：否
	 * 默认值：True
	 * 说明:是否震动
	 */
	private Boolean vibrationed;
	/**
	 * 长度：
	 * 必填：否
	 * 默认值：False
	 * 说明:是否自动安装
	 */
	private Boolean autoInstall;
	/**
	 * 长度：中/英字符
	 * 必填：否
	 * 默认值：False
	 * 说明:安装完成后是否自动启动应用程序
	 */
	private Boolean actived;
	/**
	 * 长度：40中/英字符
	 * 必填：否
	 * 默认值：
	 * 说明:
	 */
	private String androidMark;
	/**
	 * 长度：40中/英字符
	 * 必填：否
	 * 默认值：
	 * 说明:
	 */
	private String iphoneMark;
	

	public String getNotyIcon() {
		return notyIcon;
	}

	public void setNotyIcon(String notyIcon) {
		this.notyIcon = notyIcon;
	}

	public String getNotyTitle() {
		return notyTitle;
	}

	public void setNotyTitle(String notyTitle) {
		this.notyTitle = notyTitle;
	}

	public String getNotyContent() {
		return notyContent;
	}

	public void setNotyContent(String notyContent) {
		this.notyContent = notyContent;
	}

	public String getPopTitle() {
		return popTitle;
	}

	public void setPopTitle(String popTitle) {
		this.popTitle = popTitle;
	}

	public String getPopContent() {
		return popContent;
	}

	public void setPopContent(String popContent) {
		this.popContent = popContent;
	}

	public String getPopImage() {
		return popImage;
	}

	public void setPopImage(String popImage) {
		this.popImage = popImage;
	}

	public String getLoadIcon() {
		return loadIcon;
	}

	public void setLoadIcon(String loadIcon) {
		this.loadIcon = loadIcon;
	}

	public String getLoadTitle() {
		return loadTitle;
	}

	public void setLoadTitle(String loadTitle) {
		this.loadTitle = loadTitle;
	}

	public String getLoadUrl() {
		return loadUrl;
	}

	public void setLoadUrl(String loadUrl) {
		this.loadUrl = loadUrl;
	}

	public Boolean getCleared() {
		return cleared;
	}

	public void setCleared(Boolean cleared) {
		this.cleared = cleared;
	}

	public Boolean getBelled() {
		return belled;
	}

	public void setBelled(Boolean belled) {
		this.belled = belled;
	}

	public Boolean getVibrationed() {
		return vibrationed;
	}

	public void setVibrationed(Boolean vibrationed) {
		this.vibrationed = vibrationed;
	}

	public Boolean getAutoInstall() {
		return autoInstall;
	}

	public void setAutoInstall(Boolean autoInstall) {
		this.autoInstall = autoInstall;
	}

	public Boolean getActived() {
		return actived;
	}

	public void setActived(Boolean actived) {
		this.actived = actived;
	}

	public String getAndroidMark() {
		return androidMark;
	}

	public void setAndroidMark(String androidMark) {
		this.androidMark = androidMark;
	}

	public String getIphoneMark() {
		return iphoneMark;
	}

	public void setIphoneMark(String iphoneMark) {
		this.iphoneMark = iphoneMark;
	}
	
}
