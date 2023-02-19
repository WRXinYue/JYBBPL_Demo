package com.rf.common.model;

import java.util.Date;

public class Course {
	private Integer cid;
	private String cname;
	private Project pid;
	private Userinformation useridt;
	private Date cstarttime;
	private Date cattendtime;
	private Date cendtime;
	private Integer clesson;
	private String cdescribe;
	private Integer cpeonum;
	private Integer cactpeonum;
	private Subparameter cstartstatus;
	private Date creservetime;
	private Userinformation ccreateid;
	private Date ccreatetime;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Project getPid() {
		return pid;
	}
	public void setPid(Project pid) {
		this.pid = pid;
	}
	public Userinformation getUseridt() {
		return useridt;
	}
	public void setUseridt(Userinformation useridt) {
		this.useridt = useridt;
	}
	public Date getCstarttime() {
		return cstarttime;
	}
	public void setCstarttime(Date cstarttime) {
		this.cstarttime = cstarttime;
	}
	public Date getCattendtime() {
		return cattendtime;
	}
	public void setCattendtime(Date cattendtime) {
		this.cattendtime = cattendtime;
	}
	public Date getCendtime() {
		return cendtime;
	}
	public void setCendtime(Date cendtime) {
		this.cendtime = cendtime;
	}
	public Integer getClesson() {
		return clesson;
	}
	public void setClesson(Integer clesson) {
		this.clesson = clesson;
	}
	public String getCdescribe() {
		return cdescribe;
	}
	public void setCdescribe(String cdescribe) {
		this.cdescribe = cdescribe;
	}
	public Integer getCpeonum() {
		return cpeonum;
	}
	public void setCpeonum(Integer cpeonum) {
		this.cpeonum = cpeonum;
	}
	public Integer getCactpeonum() {
		return cactpeonum;
	}
	public void setCactpeonum(Integer cactpeonum) {
		this.cactpeonum = cactpeonum;
	}
	public Subparameter getCstartstatus() {
		return cstartstatus;
	}
	public void setCstartstatus(Subparameter cstartstatus) {
		this.cstartstatus = cstartstatus;
	}
	public Date getCreservetime() {
		return creservetime;
	}
	public void setCreservetime(Date creservetime) {
		this.creservetime = creservetime;
	}
	public Userinformation getCcreateid() {
		return ccreateid;
	}
	public void setCcreateid(Userinformation ccreateid) {
		this.ccreateid = ccreateid;
	}
	public Date getCcreatetime() {
		return ccreatetime;
	}
	public void setCcreatetime(Date ccreatetime) {
		this.ccreatetime = ccreatetime;
	}
}
