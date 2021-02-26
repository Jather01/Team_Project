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
}
