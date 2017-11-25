package com.dpb.base.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dpb.base.model.MenuBean;

public interface MenuBeanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MenuBean record);

    int insertSelective(MenuBean record);

    MenuBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenuBean record);

    int updateByPrimaryKey(MenuBean record);
    
    List<MenuBean> queryByUserIdList(@Param("userId")int userId,@Param("parentId")int parentId);
} 