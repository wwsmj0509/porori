package com.login.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.login.entity.login_entity;

public class login_dao {

	private static SqlSessionFactory factory;
	static {
		try {
			String resource = "mybatis/mybatis-config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
		}
	}

	// 로그인 -----------------------------------------------------------------

	public login_entity getUser(String id, String pwd) {
		SqlSession session = factory.openSession();
		login_entity logEntity = new login_entity(id, pwd);

		System.out.println(logEntity.getUserid());
		System.out.println(logEntity.getPwd());

		login_entity entity = session.selectOne("mybatis.LoginMapper.getLoginUser", logEntity);
		session.close();

		return entity;
	}

	public int getJoin(String userid, String pwd, String name, String email, String address,String chk, String profileimg) {
		
		SqlSession session = factory.openSession();
		login_entity logEntity = new login_entity(userid, pwd, name, email,address, chk,profileimg);

		int n = 0;
		try {
			n = session.insert("mybatis.LoginMapper.JoinUser", logEntity);
			if (n > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		System.out.println("join finally OK");
		return n;
	}

	
	public login_entity existCheck(String userid) {
		
		SqlSession session = factory.openSession();
		login_entity entity = session.selectOne("mybatis.LoginMapper.userExist", userid);
		
		if(entity!=null)
			System.out.println(entity.getName());
		session.close();
		return entity;
		
	}
	
}
