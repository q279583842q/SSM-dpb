package com.dpb.base.realm;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.dpb.base.dto.UserBeanDto;
import com.dpb.base.service.impl.IUserService;

public class BaseSecurityRealm extends AuthorizingRealm{
	
	@Resource
	private IUserService userService;
	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName = (String) token.getPrincipal();
		// 根据userName去数据库中查询
		UserBeanDto user = userService.login(userName);
		if(user == null){
			// 登录失败
			return null;
		}
		System.out.println("------");
		
		// 给定一个默认密码
		String password = user.getUser().getPwd();
		SimpleAuthenticationInfo sai = new SimpleAuthenticationInfo(user, password,"abc");
		return sai;
	}
	
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

}
