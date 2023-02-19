package com.rf.common.model;

import java.text.SimpleDateFormat;

public class Coachsign {
	 private int sid;
	 private Course scouid;
	 private Userinformation srecid;
	 private Subparameter srstats;
	 private SimpleDateFormat srtime;
	 private Course scoaid;
	 private Subparameter scoastats;
	 private Course scoatime;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public Course getScouid() {
		return scouid;
	}
	public void setScouid(Course scouid) {
		this.scouid = scouid;
	}
	public Userinformation getSrecid() {
		return srecid;
	}
	public void setSrecid(Userinformation srecid) {
		this.srecid = srecid;
	}
	public Subparameter getSrstats() {
		return srstats;
	}
	public void setSrstats(Subparameter srstats) {
		this.srstats = srstats;
	}
	public SimpleDateFormat getSrtime() {
		return srtime;
	}
	public void setSrtime(SimpleDateFormat srtime) {
		this.srtime = srtime;
	}
	public Course getScoaid() {
		return scoaid;
	}
	public void setScoaid(Course scoaid) {
		this.scoaid = scoaid;
	}
	public Subparameter getScoastats() {
		return scoastats;
	}
	public void setScoastats(Subparameter scoastats) {
		this.scoastats = scoastats;
	}
	public Course getScoatime() {
		return scoatime;
	}
	public void setScoatime(Course scoatime) {
		this.scoatime = scoatime;
	}
}
