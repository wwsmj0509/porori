package com.board.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.board.entity.imgBoard_entity;
import com.login.entity.login_entity;



public class imgBoard_dao {
	
	private static SqlSessionFactory factory;
	
	//Mybatis연결객체 생성--------------------------------------
	static {
		try {
			String resource="mybatis/mybatis-config.xml";
			Reader reader=Resources.getResourceAsReader(resource);
			factory=new SqlSessionFactoryBuilder().build(reader);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	//board list -----------------------------------------------------------------
	
	public List<imgBoard_entity> getImageBoardList(Map<String, Object> map) {
		SqlSession session=factory.openSession();
		List<imgBoard_entity> list=session.selectList("", map);
		session.close();
		return list;
	}
	
	
	//write -----------------------------------------------------------------
	public int boardInsert(imgBoard_entity dto) {
		SqlSession session=factory.openSession();
		int n = 0;
		
		try {
			n = session.insert("mybatis.BoardMapper.getInsertUser",dto);
			if(n > 0) {
				session.commit();
			}
		}catch(Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		System.out.println(" User Write OK");
		return n;
		
	}
	//List -----------------------------------------------------------------
	public List<imgBoard_entity> getUserList() {
		SqlSession session = factory.openSession();
		List<imgBoard_entity> list = session.selectList("mybatis.BoardMapper.getBoardList");
		
		session.close();
		return list;
	}
	//View -----------------------------------------------------------------
	public imgBoard_entity getUserView(int idx) {
		SqlSession session = factory.openSession();
		imgBoard_entity dto = session.selectOne("mybatis.BoardMapper.getBoardView",idx);
		
		session.close();
		return dto;
	}
	
	//Update -----------------------------------------------------------------
	public int boardUpdate(imgBoard_entity dto) {
		SqlSession session=factory.openSession();
		int n = 0;
		
		try {
			n = session.insert("mybatis.BoardMapper.getUpdateUser",dto);
			if(n > 0) {
				session.commit();
			}
		}catch(Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		System.out.println(" User Update OK");
		return n;
	}

	//Delete -----------------------------------------------------------------

}
