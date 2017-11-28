package com.dpb.base.dto;

import com.dpb.base.model.RoleBean;

public class RoleBeanDto extends RoleBean{

	// 第几页
	private Integer page;
	// 每页条数
	private Integer rows;
	
	private String searchMsg;

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
	
	
}
