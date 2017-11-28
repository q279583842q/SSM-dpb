package com.dpb.base.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dpb.base.dto.RoleBeanDto;
import com.dpb.base.model.RoleBean;
import com.dpb.base.service.IRoleService;
import com.github.pagehelper.PageInfo;

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
	@RequestMapping("/query")
	@ResponseBody
	public Map<String, Object> query(RoleBeanDto role){
		PageInfo<RoleBean> page = roleService.query(role);
		Map<String, Object> map = new HashMap<>();
		map.put("total", page.getTotal());
		map.put("rows",page.getList());
		return map;
	}
	
}
