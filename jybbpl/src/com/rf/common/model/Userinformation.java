package com.rf.common.model;

public class Userinformation {
	private Integer userid;
	private String username;
	private String userphone;
	private Subparameter usersex;
	private Float userheight;
	private Float userweight;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	public Subparameter getUsersex() {
		return usersex;
	}
	public void setUsersex(Subparameter usersex) {
		this.usersex = usersex;
	}
	public Float getUserheight() {
		return userheight;
	}
	public void setUserheight(Float userheight) {
		this.userheight = userheight;
	}
	public Float getUserweight() {
		return userweight;
	}
	public void setUserweight(Float userweight) {
		this.userweight = userweight;
	}
}
