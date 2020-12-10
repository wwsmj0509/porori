package com.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.imgBoard_dao;


import controller.CommandAction;

public class imgDeleteService implements CommandAction{

	@Override
	public String requestPro_action(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("delete enter");
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
				
		imgBoard_dao dao = new imgBoard_dao();
		dao.boardDelete(seq);
				
		request.setAttribute("pg", pg);
				
		return "board/delete.jsp";
		
	}

}
