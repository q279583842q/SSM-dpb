package com.dpb.base.dto;

import java.util.List;

import com.dpb.base.model.UserBean;

public class UserBeanDto extends UserBean{

	// 第几页
	private Integer page;
	// 每页条数
	private Integer rows;
	
	private String searchMsg;
	
	private List<Integer> roles;
	
	// 部门名称
	private String deptName;

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getSearchMsg() {
		return searchMsg;
	}

	public void setSearchMsg(String searchMsg) {
		this.searchMsg = searchMsg;
	}

	public List<Integer> getRoles() {
		return roles;
	}

	public void setRoles(List<Integer> roles) {
		this.roles = roles;
	}

}
