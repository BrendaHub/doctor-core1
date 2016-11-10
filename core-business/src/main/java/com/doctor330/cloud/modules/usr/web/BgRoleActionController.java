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
import com.doctor330.cloud.modules.usr.entity.BgRoleAction;
import com.doctor330.cloud.modules.usr.service.BgRoleActionService;

/**
 * 角色行为关系表Controller
 * @author 郑源
 * @version 2016-11-05
 */
@Controller
@RequestMapping(value = "${adminPath}/usr/bgRoleAction")
public class BgRoleActionController extends BaseController {

	@Autowired
	private BgRoleActionService bgRoleActionService;
	
	@ModelAttribute
	public BgRoleAction get(@RequestParam(required=false) String id) {
		BgRoleAction entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = bgRoleActionService.get(id);
		}
		if (entity == null){
			entity = new BgRoleAction();
		}
		return entity;
	}
	
	@RequiresPermissions("usr:bgRoleAction:view")
	@RequestMapping(value = {"list", ""})
	public String list(BgRoleAction bgRoleAction, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BgRoleAction> page = bgRoleActionService.findPage(new Page<BgRoleAction>(request, response), bgRoleAction); 
		model.addAttribute("page", page);
		return "modules/usr/bgRoleActionList";
	}

	@RequiresPermissions("usr:bgRoleAction:view")
	@RequestMapping(value = "form")
	public String form(BgRoleAction bgRoleAction, Model model) {
		model.addAttribute("bgRoleAction", bgRoleAction);
		return "modules/usr/bgRoleActionForm";
	}

	@RequiresPermissions("usr:bgRoleAction:edit")
	@RequestMapping(value = "save")
	public String save(BgRoleAction bgRoleAction, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, bgRoleAction)){
			return form(bgRoleAction, model);
		}
		bgRoleActionService.save(bgRoleAction);
		addMessage(redirectAttributes, "保存角色行为关系表成功");
		return "redirect:"+Global.getAdminPath()+"/usr/bgRoleAction/?repage";
	}
	
	@RequiresPermissions("usr:bgRoleAction:edit")
	@RequestMapping(value = "delete")
	public String delete(BgRoleAction bgRoleAction, RedirectAttributes redirectAttributes) {
		bgRoleActionService.delete(bgRoleAction);
		addMessage(redirectAttributes, "删除角色行为关系表成功");
		return "redirect:"+Global.getAdminPath()+"/usr/bgRoleAction/?repage";
	}

}