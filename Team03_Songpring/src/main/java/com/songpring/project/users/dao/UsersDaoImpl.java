package com.songpring.project.users.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.songpring.project.users.dto.UsersDto;

@Repository
public class UsersDaoImpl implements UsersDao{
	// 핵심 의존 객체 DI
	@Autowired
	private SqlSession session;
	
	@Override
	public int updateGrade(UsersDto dto) {
		int isSuccess=session.update("users.updateGrade",dto);
		return isSuccess;
	}
	@Override
	public List<UsersDto> getList(UsersDto dto) {
		List<UsersDto> list=session.selectList("users.getList", dto);
		return list;
	}
	@Override
	public int getCount(UsersDto dto) {
		int count=session.selectOne("users.getCount", dto);
		return count;
	}
	@Override
	public String getGrade(String id) {
		String grade=session.selectOne("users.getGrade",id);
		return grade;
	}
}
