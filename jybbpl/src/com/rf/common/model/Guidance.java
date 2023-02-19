package com.rf.common.model;

import java.util.Date;

public class Guidance {
	private Integer gid;
	private Coachcourse ccid;
	private Userinformation userid;
	private Userinformation useridt;
	private String gquestion;
	private Date gquetime;
	private Subparameter grepsta;
	private String greply;
	private Date greptime;
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public Coachcourse getCcid() {
		return ccid;
	}
	public void setCcid(Coachcourse ccid) {
		this.ccid = ccid;
	}
	public Userinformation getUserid() {
		return userid;
	}
	public void setUserid(Userinformation userid) {
		this.userid = userid;
	}
	public Userinformation getUseridt() {
		return useridt;
	}
	public void setUseridt(Userinformation useridt) {
		this.useridt = useridt;
	}
	public String getGquestion() {
		return gquestion;
	}
	public void setGquestion(String gquestion) {
		this.gquestion = gquestion;
	}
	public Date getGquetime() {
		return gquetime;
	}
	public void setGquetime(Date gquetime) {
		this.gquetime = gquetime;
	}
	public Subparameter getGrepsta() {
		return grepsta;
	}
	public void setGrepsta(Subparameter grepsta) {
		this.grepsta = grepsta;
	}
	public String getGreply() {
		return greply;
	}
	public void setGreply(String greply) {
		this.greply = greply;
	}
	public Date getGreptime() {
		return greptime;
	}
	public void setGreptime(Date greptime) {
		this.greptime = greptime;
	}
}
