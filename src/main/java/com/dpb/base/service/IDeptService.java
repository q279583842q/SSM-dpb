package com.dpb.base.service;

import java.util.List;

import com.dpb.base.model.DeptBean;

public interface IDeptService {

	int deleteByPrimaryKey(Integer id);

    int insert(DeptBean record);

    int insertSelective(DeptBean record);

    DeptBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeptBean record);

    int updateByPrimaryKey(DeptBean record);
    
    List<DeptBean> query(DeptBean record);
    
    List<DeptBean> queryAll(DeptBean record);
}
