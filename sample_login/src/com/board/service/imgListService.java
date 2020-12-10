package com.board.service;


import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.imgBoard_dao;
import com.board.entity.imgBoard_entity;

import controller.CommandAction;

public class imgListService implements CommandAction {

	@Override
	public String requestPro_action(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		imgBoard_dao dao = new imgBoard_dao();
		List<imgBoard_entity> list = dao.getUserList();
		

		//imgBoard_dao 인데   메소드이름은 getUserList 이다. 수정 필요 ,  getUserList의 맵퍼 id는 또 boardList 와  관련되어있음 이름 통일 필요
		
		request.setAttribute("list", list);
		
		return "board.jsp";
	}
}
