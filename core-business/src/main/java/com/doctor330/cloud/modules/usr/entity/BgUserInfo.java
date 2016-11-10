/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.doctor330.cloud.modules.usr.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.doctor330.cloud.common.persistence.DataEntity;

/**
 * 用户信息表Entity
 * @author 郑源
 * @version 2016-11-05
 */
public class BgUserInfo extends DataEntity<BgUserInfo> {
	
	private static final long serialVersionUID = 1L;
	private String username;		// 自动生成 bg_'六位随机数'
	private String mobile;		// mobile
	private String realname;		// realname
	private Integer sex;		// 0男姓，1女姓
	private String email;		// email
	private Integer emailvalidate;		// 0未验证，1已验证
	private Date emailvalidatedate;		// emailvalidatedate
	private String password;		// MD5之后密码
	private Integer registertype;		// 0普通注册；1联合登录绑定手机号注册
	private Date registerdate;		// registerdate
	private String headerpic;		// headerpic
	private String position;		// position
	private String company;		// company
	private String resume;		// resume
	private String wechat;		// wechat
	private String cardurl;		// cardurl
	private Integer countryid;		// 默认10036表示中国
	private Integer provinceid;		// provinceid
	private Integer cityid;		// cityid
	private Integer areaid;		// areaid
	private Integer registerfrom;		// 0	Web1	Wap2	IOS3	Android4	IPad
	private String label;		// label
	private Integer completedamount;		// completedamount
	private Date updatetime;		// updatetime
	private Integer isauth;		// 0未认证，1已认证，2:认证不通过； 默认值 0
	private Integer weight;		// 用户权重
	
	public BgUserInfo() {
		super();
	}

	public BgUserInfo(String id){
		super(id);
	}

	@Length(min=0, max=15, message="自动生成 bg_'六位随机数'长度必须介于 0 和 15 之间")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Length(min=0, max=20, message="mobile长度必须介于 0 和 20 之间")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@Length(min=0, max=20, message="realname长度必须介于 0 和 20 之间")
	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}
	
	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	@Length(min=0, max=50, message="email长度必须介于 0 和 50 之间")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getEmailvalidate() {
		return emailvalidate;
	}

	public void setEmailvalidate(Integer emailvalidate) {
		this.emailvalidate = emailvalidate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEmailvalidatedate() {
		return emailvalidatedate;
	}

	public void setEmailvalidatedate(Date emailvalidatedate) {
		this.emailvalidatedate = emailvalidatedate;
	}
	
	@Length(min=0, max=15, message="MD5之后密码长度必须介于 0 和 15 之间")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getRegistertype() {
		return registertype;
	}

	public void setRegistertype(Integer registertype) {
		this.registertype = registertype;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getRegisterdate() {
		return registerdate;
	}

	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}
	
	@Length(min=0, max=100, message="headerpic长度必须介于 0 和 100 之间")
	public String getHeaderpic() {
		return headerpic;
	}

	public void setHeaderpic(String headerpic) {
		this.headerpic = headerpic;
	}
	
	@Length(min=0, max=10, message="position长度必须介于 0 和 10 之间")
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	@Length(min=0, max=30, message="company长度必须介于 0 和 30 之间")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}
	
	@Length(min=0, max=20, message="wechat长度必须介于 0 和 20 之间")
	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	
	@Length(min=0, max=100, message="cardurl长度必须介于 0 和 100 之间")
	public String getCardurl() {
		return cardurl;
	}

	public void setCardurl(String cardurl) {
		this.cardurl = cardurl;
	}
	
	public Integer getCountryid() {
		return countryid;
	}

	public void setCountryid(Integer countryid) {
		this.countryid = countryid;
	}
	
	public Integer getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(Integer provinceid) {
		this.provinceid = provinceid;
	}
	
	public Integer getCityid() {
		return cityid;
	}

	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}
	
	public Integer getAreaid() {
		return areaid;
	}

	public void setAreaid(Integer areaid) {
		this.areaid = areaid;
	}
	
	public Integer getRegisterfrom() {
		return registerfrom;
	}

	public void setRegisterfrom(Integer registerfrom) {
		this.registerfrom = registerfrom;
	}
	
	@Length(min=0, max=128, message="label长度必须介于 0 和 128 之间")
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public Integer getCompletedamount() {
		return completedamount;
	}

	public void setCompletedamount(Integer completedamount) {
		this.completedamount = completedamount;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	
	public Integer getIsauth() {
		return isauth;
	}

	public void setIsauth(Integer isauth) {
		this.isauth = isauth;
	}
	
	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	
}