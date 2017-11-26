package com.dpb.base.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dpb.base.dao.UserBeanMapper;
import com.dpb.base.dto.UserBeanDto;
import com.dpb.base.model.UserBean;
import com.dpb.base.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class UserServiceImpl implements IUserService {
	
	@Resource
	private UserBeanMapper dao;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// 根据id删除 和角色的关联信息
		dao.deleteByUserIdRoleId(id);
		// 根据id 删除
		dao.deleteByPrimaryKey(id);
		return 1;
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

	@Override
	public PageInfo<UserBeanDto> query(UserBeanDto user) {
		// 指定分页信息
		PageHelper.startPage(user.getPage(),user.getRows());
		// 执行查询操作
		List<UserBeanDto> list = dao.query(user);
		// 将数据保存到PageInfo对象中
		PageInfo<UserBeanDto> page = new PageInfo<>(list);
		return page;
	}

	/**
	 * 添加用户并且关联相关的角色
	 */
	@Override
	public void insertUser(UserBeanDto user) throws RuntimeException {
		// TODO Auto-generated method stub
		// 1.添加用户信息
		dao.insertSelective(user);
		// 2.添加用户和角色的关联关系
		List<Integer> list = user.getRoles();
		if(list != null && list.size() > 0 ){
			for (Integer roleid : list) {
				dao.insertUserAndRole(null,roleid);
			}
		}
	}

}
