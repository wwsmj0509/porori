package com.board.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.board.dao.imgBoard_dao;
import com.board.entity.imgBoard_entity;
import com.login.entity.login_entity;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.CommandAction;

public class uploadService implements CommandAction {

	@Override
	public String requestPro_action(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");

		System.out.println("upload in");
		
		imgBoard_dao dao = new imgBoard_dao();
		
		HttpSession session = request.getSession();
		login_entity entity = (login_entity)session.getAttribute("logOK");
				
		String profileimg = dao.getprofileimg(entity);

		request.setAttribute("profileimg", profileimg);
        System.out.println("profileimg set : "+profileimg);
 
		return "/view/profile.jsp";
	}

}
