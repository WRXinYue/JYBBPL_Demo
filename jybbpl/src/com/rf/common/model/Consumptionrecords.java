package com.rf.common.model;

import java.util.Date;

public class Consumptionrecords {
	private Integer crid;
	private Userinformation userid;
	private Studentac said;
	private Date crtime;
	private Float cramount;
	public Integer getCrid() {
		return crid;
	}
	public void setCrid(Integer crid) {
		this.crid = crid;
	}
	public Userinformation getUserid() {
		return userid;
	}
	public void setUserid(Userinformation userid) {
		this.userid = userid;
	}
	public Studentac getSaid() {
		return said;
	}
	public void setSaid(Studentac said) {
		this.said = said;
	}
	public Date getCrtime() {
		return crtime;
	}
	public void setCrtime(Date crtime) {
		this.crtime = crtime;
	}
	public Float getCramount() {
		return cramount;
	}
	public void setCramount(Float cramount) {
		this.cramount = cramount;
	}


}
