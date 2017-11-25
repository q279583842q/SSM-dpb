package com.dpb.base.service;

import java.util.List;

import com.dpb.base.model.MenuBean;
import com.dpb.base.model.MenuTreeBean;

public interface IMenuService {

	int deleteByPrimaryKey(Integer id);

    int insert(MenuBean record);

    int insertSelective(MenuBean record);

    MenuBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenuBean record);

    int updateByPrimaryKey(MenuBean record);
    
    List<MenuTreeBean> queryByUserIdList(int userId);
}
