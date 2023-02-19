package com.rf.common.model;

import java.util.Date;

public class Coursereserve {
	private Integer csid;
	private Course cid;
	private Userinformation ulid;
	private Date cappointment;
	private Subparameter cappointmentstatus;
	private Userinformation ulida;
	private Date cprocessingtime;
	private String cveto;
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public Course getCid() {
		return cid;
	}
	public void setCid(Course cid) {
		this.cid = cid;
	}
	public Userinformation getUlid() {
		return ulid;
	}
	public void setUlid(Userinformation ulid) {
		this.ulid = ulid;
	}
	public Date getCappointment() {
		return cappointment;
	}
	public void setCappointment(Date cappointment) {
		this.cappointment = cappointment;
	}
	public Subparameter getCappointmentstatus() {
		return cappointmentstatus;
	}
	public void setCappointmentstatus(Subparameter cappointmentstatus) {
		this.cappointmentstatus = cappointmentstatus;
	}
	public Userinformation getUlida() {
		return ulida;
	}
	public void setUlida(Userinformation ulida) {
		this.ulida = ulida;
	}
	public Date getCprocessingtime() {
		return cprocessingtime;
	}
	public void setCprocessingtime(Date cprocessingtime) {
		this.cprocessingtime = cprocessingtime;
	}
	public String getCveto() {
		return cveto;
	}
	public void setCveto(String cveto) {
		this.cveto = cveto;
	}
	
}
