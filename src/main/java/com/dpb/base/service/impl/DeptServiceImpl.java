package com.dpb.base.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dpb.base.dao.DeptBeanMapper;
import com.dpb.base.model.DeptBean;
import com.dpb.base.service.IDeptService;
@Service
public class DeptServiceImpl implements IDeptService {
	@Resource
	private DeptBeanMapper dao;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DeptBean record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}

	@Override
	public int insertSelective(DeptBean record) {
		// TODO Auto-generated method stub
		return dao.insertSelective(record);
	}

	@Override
	public DeptBean selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(DeptBean record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DeptBean record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public List<DeptBean> query(DeptBean record) {
		// TODO Auto-generated method stub
		return dao.query(record);
	}

	@Override
	public List<DeptBean> queryAll(DeptBean record) {
		// TODO Auto-generated method stub
		return dao.query(record);
	}

}
