package com.dpb.base.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dpb.base.model.DeptBean;
import com.dpb.base.service.IDeptService;

@Controller
@RequestMapping("/sys/dept")
public class DepartmentController {
	@Resource
	private IDeptService deptService;

	@RequestMapping("/queryAll")
	@ResponseBody
	public List<DeptBean> queryAll(){
		List<DeptBean> list = deptService.queryAll(null);
		return list;
	}
}
