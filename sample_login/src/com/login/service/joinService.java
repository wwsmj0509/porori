package com.login.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.login_dao;
import com.login.entity.login_entity;

import controller.CommandAction;

public class joinService implements CommandAction{

	@Override
	public String requestPro_action(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		////////////////////////////////////
		System.out.println("회원가입 service");
		////////////////////////////////////
		
		String userid=request.getParameter("input_id");
		String pwd=request.getParameter("input_pwd");
		String name=request.getParameter("input_name");
		String email=request.getParameter("input_email");
		String address=request.getParameter("input_address");
		String chk=request.getParameter("input_chk");
		

//		System.out.println(userid);
//		System.out.println(pwd);
//		System.out.println(name);
//		System.out.println(email);
//		System.out.println(address);
//		System.out.println(chk);
		
		
		login_dao dao = new login_dao();
		
		login_entity entity = dao.existCheck(userid);
		
		int n =0;
		
		
		if(entity==null) {
			n= dao.getJoin(userid,pwd,name,email,address,chk);
			System.out.println("n : "+n);
			return "login.jsp";
		}else {
			HttpSession session=request.getSession();
			String userExistChk="유저존재";
			session.setAttribute("userExistChk", userExistChk);
			System.out.println("가입실패 중복존재");
			return "/login/signUp.jsp";
		}
		
	}

}
