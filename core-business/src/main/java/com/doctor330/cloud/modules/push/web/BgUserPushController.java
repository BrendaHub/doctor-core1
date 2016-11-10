/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.doctor330.cloud.modules.push.web;

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
import com.doctor330.cloud.modules.push.entity.BgUserPush;
import com.doctor330.cloud.modules.push.service.BgUserPushService;

/**
 * 关于消息推送的用户信息记录Controller
 * @author 郑源
 * @version 2016-11-02
 */
@Controller
@RequestMapping(value = "${adminPath}/push/bgUserPush")
public class BgUserPushController extends BaseController {

	@Autowired
	private BgUserPushService bgUserPushService;
	
	@ModelAttribute
	public BgUserPush get(@RequestParam(required=false) String id) {
		BgUserPush entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = bgUserPushService.get(id);
		}
		if (entity == null){
			entity = new BgUserPush();
		}
		return entity;
	}
	
	@RequiresPermissions("push:bgUserPush:view")
	@RequestMapping(value = {"list", ""})
	public String list(BgUserPush bgUserPush, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BgUserPush> page = bgUserPushService.findPage(new Page<BgUserPush>(request, response), bgUserPush); 
		model.addAttribute("page", page);
		return "modules/push/bgUserPushList";
	}

	@RequiresPermissions("push:bgUserPush:view")
	@RequestMapping(value = "form")
	public String form(BgUserPush bgUserPush, Model model) {
		model.addAttribute("bgUserPush", bgUserPush);
		return "modules/push/bgUserPushForm";
	}

	@RequiresPermissions("push:bgUserPush:edit")
	@RequestMapping(value = "save")
	public String save(BgUserPush bgUserPush, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, bgUserPush)){
			return form(bgUserPush, model);
		}
		bgUserPushService.save(bgUserPush);
		addMessage(redirectAttributes, "保存个推用户信息记录成功");
		return "redirect:"+Global.getAdminPath()+"/push/bgUserPush/?repage";
	}
	
	@RequiresPermissions("push:bgUserPush:edit")
	@RequestMapping(value = "delete")
	public String delete(BgUserPush bgUserPush, RedirectAttributes redirectAttributes) {
		bgUserPushService.delete(bgUserPush);
		addMessage(redirectAttributes, "删除个推用户信息记录成功");
		return "redirect:"+Global.getAdminPath()+"/push/bgUserPush/?repage";
	}

}