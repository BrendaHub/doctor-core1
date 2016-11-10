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
import com.doctor330.cloud.modules.usr.entity.BgUserRole;
import com.doctor330.cloud.modules.usr.service.BgUserRoleService;

/**
 * 用户角色关系表Controller
 * @author 郑源
 * @version 2016-11-05
 */
@Controller
@RequestMapping(value = "${adminPath}/usr/bgUserRole")
public class BgUserRoleController extends BaseController {

	@Autowired
	private BgUserRoleService bgUserRoleService;
	
	@ModelAttribute
	public BgUserRole get(@RequestParam(required=false) String id) {
		BgUserRole entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = bgUserRoleService.get(id);
		}
		if (entity == null){
			entity = new BgUserRole();
		}
		return entity;
	}
	
	@RequiresPermissions("usr:bgUserRole:view")
	@RequestMapping(value = {"list", ""})
	public String list(BgUserRole bgUserRole, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BgUserRole> page = bgUserRoleService.findPage(new Page<BgUserRole>(request, response), bgUserRole); 
		model.addAttribute("page", page);
		return "modules/usr/bgUserRoleList";
	}

	@RequiresPermissions("usr:bgUserRole:view")
	@RequestMapping(value = "form")
	public String form(BgUserRole bgUserRole, Model model) {
		model.addAttribute("bgUserRole", bgUserRole);
		return "modules/usr/bgUserRoleForm";
	}

	@RequiresPermissions("usr:bgUserRole:edit")
	@RequestMapping(value = "save")
	public String save(BgUserRole bgUserRole, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, bgUserRole)){
			return form(bgUserRole, model);
		}
		bgUserRoleService.save(bgUserRole);
		addMessage(redirectAttributes, "保存用户角色关系表成功");
		return "redirect:"+Global.getAdminPath()+"/usr/bgUserRole/?repage";
	}
	
	@RequiresPermissions("usr:bgUserRole:edit")
	@RequestMapping(value = "delete")
	public String delete(BgUserRole bgUserRole, RedirectAttributes redirectAttributes) {
		bgUserRoleService.delete(bgUserRole);
		addMessage(redirectAttributes, "删除用户角色关系表成功");
		return "redirect:"+Global.getAdminPath()+"/usr/bgUserRole/?repage";
	}

}