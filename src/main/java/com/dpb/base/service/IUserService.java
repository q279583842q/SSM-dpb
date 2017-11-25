package com.dpb.base.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.dpb.base.dto.UserBeanDto;
import com.dpb.base.model.UserBean;

public interface IUserService {

	int deleteByPrimaryKey(Integer id);

    int insert(UserBean record);

    int insertSelective(UserBean record);

    UserBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserBean record);

    int updateByPrimaryKey(UserBean record);
    
    /**
     * 根据用户名查询用户信息  登录
     * @param userName
     * @return
     */
    UserBeanDto login(String userName);
    
    /**
     * 查询用户信息
     * @param user
     * @return
     */
    List<UserBeanDto> query(UserBean user);
}
