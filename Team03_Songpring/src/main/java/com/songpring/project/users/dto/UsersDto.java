package com.songpring.project.users.dto;

public class UsersDto {
	private String name;
	private String id;
	private String pwd;
	private String email;
	private String profile;
	private String regdate;
	private String newPwd;
	private String useraddr1;
	private String useraddr2;
	private String useraddr3;
	private String grade;
	// 페이징 처리
	private int startRowNum;
	private int endRowNum;
	public UsersDto() {}
	public UsersDto(String name, String id, String pwd, String email, String profile, String regdate, String newPwd,
			String useraddr1, String useraddr2, String useraddr3, String grade, int startRowNum, int endRowNum) {
		super();
		this.name=name;
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.profile = profile;
		this.regdate = regdate;
		this.newPwd = newPwd;
		this.useraddr1 = useraddr1;
		this.useraddr2 = useraddr2;
		this.useraddr3 = useraddr3;
		this.grade = grade;
		this.startRowNum = startRowNum;
		this.endRowNum = endRowNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	public String getUseraddr1() {
		return useraddr1;
	}
	public void setUseraddr1(String useraddr1) {
		this.useraddr1 = useraddr1;
	}
	public String getUseraddr2() {
		return useraddr2;
	}
	public void setUseraddr2(String useraddr2) {
		this.useraddr2 = useraddr2;
	}
	public String getUseraddr3() {
		return useraddr3;
	}
	public void setUseraddr3(String useraddr3) {
		this.useraddr3 = useraddr3;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getStartRowNum() {
		return startRowNum;
	}
	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}
	public int getEndRowNum() {
		return endRowNum;
	}
	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}
	
}
