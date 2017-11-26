package com.dpb.base.service;

import java.util.List;

import com.dpb.base.model.RoleBean;

public interface IRoleService {

	int deleteByPrimaryKey(Integer id);

    int insert(RoleBean record);

    int insertSelective(RoleBean record);

    RoleBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleBean record);

    int updateByPrimaryKey(RoleBean record);
    
    /**
     * 分页查询
     * @param role
     * @return
     */
    List<RoleBean> query(RoleBean role);
    
    /**
     * 查询所有
     * @param role
     * @return
     */
    List<RoleBean> queryAll(RoleBean role);
}
