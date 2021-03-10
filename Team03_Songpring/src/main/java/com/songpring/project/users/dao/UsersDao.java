package com.songpring.project.users.dao;

import java.util.List;

import com.songpring.project.users.dto.UsersDto;

public interface UsersDao {
	// 권한 부여
	public int updateGrade(UsersDto dto);
	// 유저 목록
	public List<UsersDto> getList(UsersDto dto);
	// 회원 수
	public int getCount(UsersDto dto);
	//비밀번호 수정하고 성공여부 리턴
	public boolean updatePwd(UsersDto dto);
	//회원가입 정보 수정 반영
	public void update(UsersDto dto);
	//인자로 전달된 아이디에 해당하는 비밀번호를 리턴하는 메소드
	public String getPwd(String id);
	//회원가입 정보 삭제
	public void delete(String id);
}
