package com.dpb.base.dto;

import com.dpb.base.model.UserBean;

public class UserBeanDto {

	private UserBean user;
	
	// 部门名称
	private String deptName;

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
}
