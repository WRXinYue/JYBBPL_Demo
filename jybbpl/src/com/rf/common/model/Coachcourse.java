package com.rf.common.model;

import java.util.Date;

public class Coachcourse {
	private Integer ccid;
	private Course ucid;
	private Date ccattendtime;
	private Date ccendtime;
	private Userinformation ccreateid;
	private Userinformation useridt;
	private Subparameter ccheckstart;
	public Integer getCcid() {
		return ccid;
	}
	public void setCcid(Integer ccid) {
		this.ccid = ccid;
	}
	public Course getUcid() {
		return ucid;
	}
	public void setUcid(Course ucid) {
		this.ucid = ucid;
	}
	public Date getCcattendtime() {
		return ccattendtime;
	}
	public void setCcattendtime(Date ccattendtime) {
		this.ccattendtime = ccattendtime;
	}
	public Date getCcendtime() {
		return ccendtime;
	}
	public void setCcendtime(Date ccendtime) {
		this.ccendtime = ccendtime;
	}
	public Userinformation getCcreateid() {
		return ccreateid;
	}
	public void setCcreateid(Userinformation ccreateid) {
		this.ccreateid = ccreateid;
	}
	public Userinformation getUseridt() {
		return useridt;
	}
	public void setUseridt(Userinformation useridt) {
		this.useridt = useridt;
	}
	public Subparameter getCcheckstart() {
		return ccheckstart;
	}
	public void setCcheckstart(Subparameter ccheckstart) {
		this.ccheckstart = ccheckstart;
	}
}
