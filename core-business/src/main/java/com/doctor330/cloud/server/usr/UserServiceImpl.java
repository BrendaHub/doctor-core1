package com.doctor330.cloud.server.usr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.doctor330.cloud.common.base.BaseService;
import com.doctor330.cloud.common.persistence.Page;
import com.doctor330.cloud.modules.usr.dao.BgUserInfoDao;
import com.doctor330.cloud.modules.usr.entity.BgUserInfo;

@Service("userService")
public class UserServiceImpl extends BaseService  implements IUserService {

	@Autowired
	BgUserInfoDao userInfoDao;

	public String getBigShotList(String orderBy, Integer pageNo, Integer pageSize) {

		// 返回值的定义
		ArrayList<Map<String, Object>> bigShotReturnList = new ArrayList<Map<String, Object>>();
		// 查询条件的定义
		BgUserInfo query = new BgUserInfo();
		// 分页条件
		Page<BgUserInfo> page = new Page<BgUserInfo>();
	/*	if (pageNo != null && pageSize != null) {
			page.setPageNo(pageNo);
			page.setPageSize(pageSize);
		}
		// 排序条件
		if (orderBy != null && orderBy.length() > 0 && (orderBy.contains("desc") || orderBy.contains("asc"))) {
			page.setOrderBy(orderBy);
		}
		query.setPage(page);*/
		// 获取大咖列表
		List<BgUserInfo> bigShotList = userInfoDao.findRoleList(query);
		for (BgUserInfo bgUserInfo : bigShotList) {
			Map<String, Object> bigShotMap = new HashMap<String, Object>();
			bigShotMap.put("userId", (bgUserInfo.getId()== null) ? "" : bgUserInfo.getId());
			bigShotMap.put("mobile", bgUserInfo.getMobile()== null ? "" : bgUserInfo.getMobile());
			bigShotMap.put("userName", bgUserInfo.getUsername()== null ? "" :bgUserInfo.getUsername() );
			bigShotMap.put("realName", bgUserInfo.getRealname()== null ? "" : bgUserInfo.getRealname());
			bigShotMap.put("sex", bgUserInfo.getSex()== null ? "" : bgUserInfo.getSex());
			bigShotMap.put("company", bgUserInfo.getCompany()== null ? "" : bgUserInfo.getCompany());
			bigShotMap.put("cardUrl", bgUserInfo.getCardurl()== null ? "" : bgUserInfo.getCardurl());
			bigShotMap.put("email", bgUserInfo.getEmail()== null ? "" : bgUserInfo.getEmail());
			bigShotReturnList.add(bigShotMap);
		}
		return this.getJsonString(bigShotReturnList);
	}

	@Override
	public String getBigShotDetail(Integer userID) {
		//获取用户信息
		BgUserInfo bgUserInfo = userInfoDao.get(userID+"");
		//封装返回的用户信息
		Map<String,Object> bigShotMap = new HashMap<String,Object>();
		bigShotMap.put("userId", (bgUserInfo.getId()== null) ? "" : bgUserInfo.getId());
		bigShotMap.put("mobile", bgUserInfo.getMobile()== null ? "" : bgUserInfo.getMobile());
		bigShotMap.put("userName", bgUserInfo.getUsername()== null ? "" :bgUserInfo.getUsername() );
		bigShotMap.put("realName", bgUserInfo.getRealname()== null ? "" : bgUserInfo.getRealname());
		bigShotMap.put("sex", bgUserInfo.getSex()== null ? "" : bgUserInfo.getSex());
		bigShotMap.put("company", bgUserInfo.getCompany()== null ? "" : bgUserInfo.getCompany());
		bigShotMap.put("cardUrl", bgUserInfo.getCardurl()== null ? "" : bgUserInfo.getCardurl());
		bigShotMap.put("email", bgUserInfo.getEmail()== null ? "" : bgUserInfo.getEmail());
		return this.getJsonString(bigShotMap);
	}

	@Override
	public String addUser(String userInfo) {
		int result = 0;
		try {
			
			JSONObject userInfoObj = (JSONObject) JSON.parse(userInfo);
			String realName = (String) userInfoObj.get("realName");
			Integer sex = Integer.parseInt(userInfoObj.get("sex").toString());
			String mobile = (String) userInfoObj.get("mobile");
			System.out.println(realName);
			System.out.println(sex);
			System.out.println(mobile);
			BgUserInfo bgUserInfo = new BgUserInfo();
			bgUserInfo.setRealname(realName);
			bgUserInfo.setSex(sex);
			bgUserInfo.setMobile(mobile);
			result = userInfoDao.insert(bgUserInfo);/**/
//			userInfoObj.get("");
//			userInfoObj.get("");
			//			userInfoObj.get("");
			return "success";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result == 1)
			return "success";
		else
			return "false";
	}

}
