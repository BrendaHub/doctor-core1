/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.doctor330.cloud.modules.usr.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.doctor330.cloud.common.config.Global;
import com.doctor330.cloud.common.persistence.Page;
import com.doctor330.cloud.common.web.BaseController;
import com.doctor330.cloud.common.utils.StringUtils;
import com.doctor330.cloud.modules.usr.entity.BgUserInfo;
import com.doctor330.cloud.modules.usr.service.BgUserInfoService;

/**
 * 用户信息表Controller
 * @author 郑源
 * @version 2016-11-05
 */
@Controller
@RequestMapping(value = "${adminPath}/usr/bgUserInfo")
public class BgUserInfoController extends BaseController {

	@Autowired
	private BgUserInfoService bgUserInfoService;
	
	@ModelAttribute
	public BgUserInfo get(@RequestParam(required=false) String id) {
		BgUserInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = bgUserInfoService.get(id);
		}
		if (entity == null){
			entity = new BgUserInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("usr:bgUserInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(BgUserInfo bgUserInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BgUserInfo> page = bgUserInfoService.findPage(new Page<BgUserInfo>(request, response), bgUserInfo); 
		model.addAttribute("page", page);
		return "modules/usr/bgUserInfoList";
	}

	@RequiresPermissions("usr:bgUserInfo:view")
	@RequestMapping(value = "form")
	public String form(BgUserInfo bgUserInfo, Model model) {
		model.addAttribute("bgUserInfo", bgUserInfo);
		return "modules/usr/bgUserInfoForm";
	}

	@RequiresPermissions("usr:bgUserInfo:edit")
	@RequestMapping(value = "save")
	public String save(BgUserInfo bgUserInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, bgUserInfo)){
			return form(bgUserInfo, model);
		}
		bgUserInfoService.save(bgUserInfo);
		addMessage(redirectAttributes, "保存用户信息表成功");
		return "redirect:"+Global.getAdminPath()+"/usr/bgUserInfo/?repage";
	}
	
	@RequiresPermissions("usr:bgUserInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(BgUserInfo bgUserInfo, RedirectAttributes redirectAttributes) {
		bgUserInfoService.delete(bgUserInfo);
		addMessage(redirectAttributes, "删除用户信息表成功");
		return "redirect:"+Global.getAdminPath()+"/usr/bgUserInfo/?repage";
	}

}