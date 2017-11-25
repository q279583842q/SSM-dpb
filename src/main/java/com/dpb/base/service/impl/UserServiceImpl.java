package com.dpb.base.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dpb.base.dao.UserBeanMapper;
import com.dpb.base.dto.UserBeanDto;
import com.dpb.base.model.UserBean;
@Service
public class UserServiceImpl implements IUserService {
	
	@Resource
	private UserBeanMapper dao;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(UserBean record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}

	@Override
	public int insertSelective(UserBean record) {
		// TODO Auto-generated method stub
		return dao.insertSelective(record);
	}

	@Override
	public UserBean selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(UserBean record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(UserBean record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public UserBeanDto login(String userName) {
		// TODO Auto-generated method stub
		return dao.login(userName);
	}

}
