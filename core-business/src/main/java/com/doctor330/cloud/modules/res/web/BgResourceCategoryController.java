/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.doctor330.cloud.modules.res.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.doctor330.cloud.common.config.Global;
import com.doctor330.cloud.common.persistence.Page;
import com.doctor330.cloud.common.web.BaseController;
import com.doctor330.cloud.common.utils.StringUtils;
import com.doctor330.cloud.modules.res.entity.BgResourceCategory;
import com.doctor330.cloud.modules.res.service.BgResourceCategoryService;

/**
 * 行业管理的增删改查Controller
 * @author 武海升
 * @version 2016-11-05
 */
@Controller
@RequestMapping(value = "${adminPath}/res/bgResourceCategory")
public class BgResourceCategoryController extends BaseController {

	@Autowired
	private BgResourceCategoryService bgResourceCategoryService;
	
	@ModelAttribute
	public BgResourceCategory get(@RequestParam(required=false) String id) {
		BgResourceCategory entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = bgResourceCategoryService.get(id);
		}
		if (entity == null){
			entity = new BgResourceCategory();
		}
		return entity;
	}
	
	

	@RequiresPermissions("res:bgResourceCategory:view")
	@RequestMapping(value = "form")
	public String form(BgResourceCategory bgResourceCategory, Model model) {
		List<BgResourceCategory> findFatherList = bgResourceCategoryService.findFatherList(bgResourceCategory);
		model.addAttribute("findFatherList", findFatherList);
		model.addAttribute("bgResourceCategory", bgResourceCategory);
		return "modules/res/bgResourceCategoryForm";
	}
	
	@RequiresPermissions("res:bgResourceCategory:view")
	@RequestMapping(value = {"list", ""})
	public String list(BgResourceCategory bgResourceCategory, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BgResourceCategory> page = bgResourceCategoryService.findPage(new Page<BgResourceCategory>(request, response), bgResourceCategory); 
		model.addAttribute("page", page);
		return "modules/res/bgResourceCategoryList";
	}

	@RequiresPermissions("res:bgResourceCategory:edit")
	@RequestMapping(value = "save")
	public String save(BgResourceCategory bgResourceCategory, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, bgResourceCategory)){
			return form(bgResourceCategory, model);
		}
		
		bgResourceCategory.setAddtime(new Date());
		bgResourceCategoryService.save(bgResourceCategory);
		addMessage(redirectAttributes, "保存行业表成功");
		return "redirect:"+Global.getAdminPath()+"/res/bgResourceCategory/?repage";
	}
	
	@RequiresPermissions("res:bgResourceCategory:edit")
	@RequestMapping(value = "delete")
	public String delete(BgResourceCategory bgResourceCategory, RedirectAttributes redirectAttributes) {
		bgResourceCategoryService.delete(bgResourceCategory);
		addMessage(redirectAttributes, "删除行业表成功");
		return "redirect:"+Global.getAdminPath()+"/res/bgResourceCategory/?repage";
	}
	
	@RequestMapping(value = "getID", method = {RequestMethod.POST})
	@ResponseBody
	public String getID(@RequestParam("id") String id) {
		int isOrder = 0;
		try{
			isOrder = bgResourceCategoryService.getIsOrder(id)+1;
		}catch(Exception e){
			isOrder ++ ;
		}
		return String.valueOf(isOrder);
	}

}