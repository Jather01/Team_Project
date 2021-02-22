package com.gura.spring05.user.dao;

import com.gura.spring05.user.dto.UsersDto;

public interface UsersDao {
	// 프로필 이미지 변경
	public void updateProfile(UsersDto dto);
	// 아이디 중복 확인
	public boolean isExist(String id);
	// 비밀번호 변경
	public boolean updatePwd(UsersDto dto);
	// 회원 가입 정보 수정 반영
	public void update(UsersDto dto);
	// 회원 정보 삭제
	public void delete(String id);
	// 가입 정보
	public UsersDto getData(String id);
	// 회원 정보 추가
	public void insert(UsersDto dto);
	// 인자로 전달된 아이디에 해당하는 비밀번호를 리턴하는 메소드
	public String getPwd(String id);
}
