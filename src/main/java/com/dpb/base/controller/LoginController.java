package com.dpb.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dpb.base.model.UserBean;

@Controller
@RequestMapping("/")
public class LoginController {

	@RequestMapping("/login")
	@ResponseBody
	public String login(UserBean user, HttpServletRequest request){
		System.out.println("----");
		Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPwd());
        try{
            subject.login(token);//会跳到我们自定义的realm中
            request.getSession().setAttribute("user", subject.getPrincipal());
            return "1";
        }catch(Exception e){
            e.printStackTrace();
            request.getSession().setAttribute("user", user);
            request.setAttribute("error", "用户名或密码错误！");
            return "login";
        }
	}
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return request.getContextPath()+"/login.jsp";
	}
}
