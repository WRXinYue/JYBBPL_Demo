package com.rf.common.model;

import java.util.Date;

public class Rate {
	private Integer rateid;
	private Coachcourse ccid;
	private Userinformation userId;
	private Userinformation useridt;
	private Subparameter ratelevel;
	private Date ratetime;
	public Integer getRateid() {
		return rateid;
	}
	public void setRateid(Integer rateid) {
		this.rateid = rateid;
	}
	public Coachcourse getCcid() {
		return ccid;
	}
	public void setCcid(Coachcourse ccid) {
		this.ccid = ccid;
	}
	public Userinformation getUserId() {
		return userId;
	}
	public void setUserId(Userinformation userId) {
		this.userId = userId;
	}
	public Userinformation getUseridt() {
		return useridt;
	}
	public void setUseridt(Userinformation useridt) {
		this.useridt = useridt;
	}
	public Subparameter getRatelevel() {
		return ratelevel;
	}
	public void setRatelevel(Subparameter ratelevel) {
		this.ratelevel = ratelevel;
	}
	public Date getRatetime() {
		return ratetime;
	}
	public void setRatetime(Date ratetime) {
		this.ratetime = ratetime;
	}
}
