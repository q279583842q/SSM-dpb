package com.dpb.base.model;

import java.util.ArrayList;
import java.util.List;

public class MenuTreeBean {

	private int id;
	
	private String text;
	
	private String iconCls;
	
	private List<MenuTreeBean> children = new ArrayList<>();
	
	private String url;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public List<MenuTreeBean> getChildren() {
		return children;
	}

	public void setChildren(List<MenuTreeBean> children) {
		this.children = children;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
