package com.rf.common.model;

import java.util.Date;

public class Recharge {
	private Integer reid;
	private Userinformation userid;
	private Userinformation userida;
	private Date retime;
	private Float reamo;
	public Integer getReid() {
		return reid;
	}
	public void setReid(Integer reid) {
		this.reid = reid;
	}
	public Userinformation getUserid() {
		return userid;
	}
	public void setUserid(Userinformation userid) {
		this.userid = userid;
	}
	public Userinformation getUserida() {
		return userida;
	}
	public void setUserida(Userinformation userida) {
		this.userida = userida;
	}
	public Date getRetime() {
		return retime;
	}
	public void setRetime(Date retime) {
		this.retime = retime;
	}
	public Float getReamo() {
		return reamo;
	}
	public void setReamo(Float reamo) {
		this.reamo = reamo;
	}
}
