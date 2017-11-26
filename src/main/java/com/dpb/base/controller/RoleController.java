package com.dpb.base.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dpb.base.model.RoleBean;
import com.dpb.base.service.IRoleService;

@Controller
@RequestMapping("/sys/role")
public class RoleController {
	
	@Resource
	private IRoleService roleService;

	/**
	 * 查询所有
	 * @return
	 */
	@RequestMapping("/queryAll")
	@ResponseBody
	public List<RoleBean> queryAll(){
		List<RoleBean> list = roleService.queryAll(null);
		return list;
	}
	
}
