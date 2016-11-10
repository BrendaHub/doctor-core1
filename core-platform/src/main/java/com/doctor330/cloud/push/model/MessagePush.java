package com.doctor330.cloud.push.model;

import java.io.Serializable;
import java.util.Date;

public class MessagePush implements Serializable {
    private Integer id;

    private Integer userid;

    private String clientid;

    private Date addtime;

    /**
     * 手机端检查和原来不相等就更新
     */
    private String appversion;

    private String ostype;

    private Date updatetime;

    /**
     * 0 正常状态 1 删除状态
     */
    private Integer state;
    
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid == null ? null : clientid.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion == null ? null : appversion.trim();
    }

    public String getOstype() {
        return ostype;
    }

    public void setOstype(String ostype) {
        this.ostype = ostype == null ? null : ostype.trim();
    }

    
    public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "MessagePush [id=" + id + ", userid=" + userid + ", clientid=" + clientid + ", addtime=" + addtime
				+ ", appversion=" + appversion + ", ostype=" + ostype + ", updatetime=" + updatetime + ", state="
				+ state + "]";
	}
}
