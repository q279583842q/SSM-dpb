package com.dpb.base.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dpb.base.dao.MenuBeanMapper;
import com.dpb.base.model.MenuBean;
import com.dpb.base.model.MenuTreeBean;
import com.dpb.base.service.IMenuService;
@Service
public class MenuServiceImpl implements IMenuService {
	@Resource
	private MenuBeanMapper dao;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(MenuBean record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}

	@Override
	public int insertSelective(MenuBean record) {
		// TODO Auto-generated method stub
		return dao.insertSelective(record);
	}

	@Override
	public MenuBean selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(MenuBean record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(MenuBean record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(record);
	}

	/**
	 * 查询出当前用户具有的所有的菜单，然后封装到MenuTreeBean中
	 */
	@Override
	public List<MenuTreeBean> queryByUserIdList(int userId) {
		
		List<MenuTreeBean> trees = new ArrayList<>();
		getTreeNode(trees,userId,0);
		return trees;
	}
	/**
	 * 取出当前用户的所有菜单并封装到MenuTreeBean集合中
	 * @param trees 容器
	 * @param userId 用户id
	 * @param parentId 父id
	 */
	public void getTreeNode(List<MenuTreeBean> trees,int userId,int parentId){
		List<MenuBean> list = dao.queryByUserIdList(userId, parentId);
		if(list != null && list.size() > 0){
			for (MenuBean menu : list) {
				MenuTreeBean tree = new MenuTreeBean();
				tree.setId(menu.getId());
				tree.setText(menu.getMenuname());
				tree.setUrl(menu.getMenulink());
				trees.add(tree);
				// 将该节点添加到父节点中
				getTreeNode(tree.getChildren(),userId,menu.getId());
			}
		}
	}

}
