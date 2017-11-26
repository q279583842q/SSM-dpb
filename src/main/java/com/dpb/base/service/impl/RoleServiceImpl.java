package com.dpb.base.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dpb.base.dao.RoleBeanMapper;
import com.dpb.base.model.RoleBean;
import com.dpb.base.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {
	@Resource
	private RoleBeanMapper dao;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(RoleBean record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}

	@Override
	public int insertSelective(RoleBean record) {
		// TODO Auto-generated method stub
		return dao.insertSelective(record);
	}

	@Override
	public RoleBean selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(RoleBean record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(RoleBean record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public List<RoleBean> query(RoleBean role) {
		// TODO Auto-generated method stub
		return dao.query(role);
	}

	@Override
	public List<RoleBean> queryAll(RoleBean role) {
		// TODO Auto-generated method stub
		return dao.query(role);
	}

}
