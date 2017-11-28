package com.dpb.base.dto;

import java.util.ArrayList;
import java.util.List;

import com.dpb.base.model.MenuBean;

public class MenuBeanDto extends MenuBean{

	private List<MenuBeanDto> children = new ArrayList<>();

	public List<MenuBeanDto> getChildren() {
		return children;
	}

	public void setChildren(List<MenuBeanDto> children) {
		this.children = children;
	}
}
