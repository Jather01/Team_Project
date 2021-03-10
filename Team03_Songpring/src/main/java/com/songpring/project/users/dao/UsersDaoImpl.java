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
	public boolean updatePwd(UsersDto dto) {
		int count=session.update("users.updatePwd", dto);
		if(count==0) {
			return false;
		}else {
			return true;
		}
	}
	@Override
	public void update(UsersDto dto) {
		session.update("users.update", dto);
	}
	@Override
	public String getPwd(String id) {
		//아이디를 이용해서 저장된 비밀번호를  SELECT 해서 
		String pwd=session.selectOne("users.getPwd", id);
		//리턴해준다.
		return pwd;
	}
	@Override
	public void delete(String id) {

		session.delete("users.delete", id);
	}
}
