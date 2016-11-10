/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.doctor330.cloud.modules.res.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.doctor330.cloud.common.persistence.DataEntity;

/**
 * 行业管理的增删改查Entity
 * @author 武海升
 * @version 2016-11-05
 */
public class BgResourceCategory extends DataEntity<BgResourceCategory> {
	
	private static final long serialVersionUID = 1L;
	private String categoryname;		// categoryname
	private String encategoryname;		// encategoryname
	private String fathercatid;		// fathercatid
	private String fathercatname;		// fathercatname
	private String isorder;		// isorder
	private String isuse;		// 0未启用1启用
	private String remark;		// remark
	private Date addtime;		// addtime
	private String adduser;		// adduser
	private Date updatetime;		// updatetime
	private String updateuser;		// updateuser
	private String templateid;		// templateid
	private String originalpicurl;		// originalpicurl
	private String bigpicurl;		// bigpicurl
	private String centerpicurl;		// centerpicurl
	private String smallpicurl;		// smallpicurl
	
	public BgResourceCategory() {
		super();
	}

	public BgResourceCategory(String id){
		super(id);
	}

	@Length(min=0, max=100, message="categoryname长度必须介于 0 和 100 之间")
	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	
	@Length(min=0, max=100, message="encategoryname长度必须介于 0 和 100 之间")
	public String getEncategoryname() {
		return encategoryname;
	}

	public void setEncategoryname(String encategoryname) {
		this.encategoryname = encategoryname;
	}
	
	@Length(min=0, max=11, message="fathercatid长度必须介于 0 和 11 之间")
	public String getFathercatid() {
		return fathercatid;
	}

	public void setFathercatid(String fathercatid) {
		this.fathercatid = fathercatid;
	}
	
	@Length(min=0, max=100, message="fathercatname长度必须介于 0 和 100 之间")
	public String getFathercatname() {
		return fathercatname;
	}

	public void setFathercatname(String fathercatname) {
		this.fathercatname = fathercatname;
	}
	
	@Length(min=0, max=11, message="isorder长度必须介于 0 和 11 之间")
	public String getIsorder() {
		return isorder;
	}

	public void setIsorder(String isorder) {
		this.isorder = isorder;
	}
	
	@Length(min=0, max=11, message="0未启用1启用长度必须介于 0 和 11 之间")
	public String getIsuse() {
		return isuse;
	}

	public void setIsuse(String isuse) {
		this.isuse = isuse;
	}
	
	@Length(min=0, max=300, message="remark长度必须介于 0 和 300 之间")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	
	@Length(min=0, max=100, message="adduser长度必须介于 0 和 100 之间")
	public String getAdduser() {
		return adduser;
	}

	public void setAdduser(String adduser) {
		this.adduser = adduser;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	
	@Length(min=0, max=100, message="updateuser长度必须介于 0 和 100 之间")
	public String getUpdateuser() {
		return updateuser;
	}

	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
	}
	
	@Length(min=0, max=11, message="templateid长度必须介于 0 和 11 之间")
	public String getTemplateid() {
		return templateid;
	}

	public void setTemplateid(String templateid) {
		this.templateid = templateid;
	}
	
	@Length(min=0, max=300, message="originalpicurl长度必须介于 0 和 300 之间")
	public String getOriginalpicurl() {
		return originalpicurl;
	}

	public void setOriginalpicurl(String originalpicurl) {
		this.originalpicurl = originalpicurl;
	}
	
	@Length(min=0, max=300, message="bigpicurl长度必须介于 0 和 300 之间")
	public String getBigpicurl() {
		return bigpicurl;
	}

	public void setBigpicurl(String bigpicurl) {
		this.bigpicurl = bigpicurl;
	}
	
	@Length(min=0, max=300, message="centerpicurl长度必须介于 0 和 300 之间")
	public String getCenterpicurl() {
		return centerpicurl;
	}

	public void setCenterpicurl(String centerpicurl) {
		this.centerpicurl = centerpicurl;
	}
	
	@Length(min=0, max=300, message="smallpicurl长度必须介于 0 和 300 之间")
	public String getSmallpicurl() {
		return smallpicurl;
	}

	public void setSmallpicurl(String smallpicurl) {
		this.smallpicurl = smallpicurl;
	}
	
}