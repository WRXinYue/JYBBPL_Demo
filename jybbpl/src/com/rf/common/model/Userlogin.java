package com.rf.common.model;

public class Userlogin {
	private Integer ulid;
	private String ulphone;
	private Userinformation userid;
	private String ulpassword;
	private Subparameter ulstatus;
	private Subparameter ullosure;
	private Purview ulpowerid;
	private Float ulbalance;
	public Userinformation getUserid() {
		return userid;
	}
	public void setUserid(Userinformation userid) {
		this.userid = userid;
	}
	public Integer getUlid() {
		return ulid;
	}
	public void setUlid(Integer ulid) {
		this.ulid = ulid;
	}
	public String getUlphone() {
		return ulphone;
	}
	public void setUlphone(String ulphone) {
		this.ulphone = ulphone;
	}
	public String getUlpassword() {
		return ulpassword;
	}
	public void setUlpassword(String ulpassword) {
		this.ulpassword = ulpassword;
	}
	public Subparameter getUlstatus() {
		return ulstatus;
	}
	public void setUlstatus(Subparameter ulstatus) {
		this.ulstatus = ulstatus;
	}
	public Subparameter getUllosure() {
		return ullosure;
	}
	public void setUllosure(Subparameter ullosure) {
		this.ullosure = ullosure;
	}
	public Purview getUlpowerid() {
		return ulpowerid;
	}
	public void setUlpowerid(Purview ulpowerid) {
		this.ulpowerid = ulpowerid;
	}
	public Float getUlbalance() {
		return ulbalance;
	}
	public void setUlbalance(Float ulbalance) {
		this.ulbalance = ulbalance;
	}
}
