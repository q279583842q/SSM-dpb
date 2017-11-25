package com.dpb.base.dao;

import com.dpb.base.model.RoleBean;

public interface RoleBeanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleBean record);

    int insertSelective(RoleBean record);

    RoleBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleBean record);

    int updateByPrimaryKey(RoleBean record);
}