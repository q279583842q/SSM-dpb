package com.dpb.base.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dpb.base.dto.UserBeanDto;
import com.dpb.base.service.IUserService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sys/user")
public class UserController {

	@Resource
	private IUserService userService;

	/**
	 * 查询所有的用户信息
	 * 
	 * @return
	 */
	@RequestMapping("/query")
	@ResponseBody
	public Map<String, Object> query(UserBeanDto user) {
		PageInfo<UserBeanDto> page = userService.query(user);
		Map<String, Object> map = new HashMap<>();
		map.put("total", page.getTotal());
		map.put("rows",page.getList());
		return map;
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public String save(UserBeanDto user){
		userService.insertUser(user);
		return "1";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(UserBeanDto user){
		userService.updateByPrimaryKeySelective(user);
		return "1";
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(UserBeanDto user){
		userService.deleteByPrimaryKey(user.getId());
		return "1";
	}


}
