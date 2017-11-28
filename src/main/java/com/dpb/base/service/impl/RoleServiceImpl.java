package com.dpb.base.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dpb.base.dao.RoleBeanMapper;
import com.dpb.base.dto.RoleBeanDto;
import com.dpb.base.dto.UserBeanDto;
import com.dpb.base.model.RoleBean;
import com.dpb.base.service.IRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
	public PageInfo<RoleBean> query(RoleBeanDto role) {
		// 指定分页信息
		PageHelper.startPage(role.getPage(),role.getRows());
		// 执行查询操作
		List<RoleBean> list = dao.query(role);
		// 将数据保存到PageInfo对象中
		PageInfo<RoleBean> page = new PageInfo<>(list);
		return page;
	}

	@Override
	public List<RoleBean> queryAll(RoleBean role) {
		// TODO Auto-generated method stub
		return dao.query(role);
	}

}
