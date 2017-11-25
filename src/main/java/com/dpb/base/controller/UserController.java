package com.dpb.base.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dpb.base.dto.UserBeanDto;
import com.dpb.base.model.UserBean;
import com.dpb.base.service.IUserService;

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
	public Map<String, Object> query(UserBean user) {
		List<UserBeanDto> list = userService.query(user);
		Map<String, Object> map = new HashMap<>();
		map.put("total", list.size());
		map.put("rows", list);
		return map;
	}

}
