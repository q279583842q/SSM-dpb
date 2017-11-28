package com.dpb.base.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dpb.base.dto.MenuBeanDto;
import com.dpb.base.model.MenuBean;
import com.dpb.base.model.MenuTreeBean;
import com.dpb.base.service.IMenuService;

@Controller
@RequestMapping("/sys/menu")
public class MenuController {

	@Resource
	private IMenuService menuService;
	
	@RequestMapping("/query")
	@ResponseBody
	public List<MenuBeanDto> query(MenuBean menu){
		List<MenuBeanDto> list = menuService.query(menu);
		return list;
	}
}
