package com.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.imgBoard_dao;
import com.board.entity.imgBoard_entity;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.CommandAction;

public class imgInsertService implements CommandAction{

	@Override
	public String requestPro_action(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("insert enter");
		
		//실제 저장 경로
		String realFolder = request.getServletContext().getRealPath("/storage");
		//System.out.println("저장 폴더:" + realFolder);
		
		//파일업로드
		MultipartRequest multi=new MultipartRequest(
		        request, realFolder, 5*1024*1024, "UTF-8",new DefaultFileRenamePolicy());
				
		imgBoard_entity entity = new imgBoard_entity();
		entity.setUserid(request.getParameter("userid"));
		entity.setImgPath(multi.getFilesystemName("imgpath"));
		entity.setContent(request.getParameter("content"));
		
		imgBoard_dao boardDao = new imgBoard_dao();
		int n = boardDao.boardInsert(entity);
		
		if(n > 0) {
			request.setAttribute("insertOK", n);
			return "boardList.do";
		}else {
			return "write/user_write.jsp";
		}
	}

}
