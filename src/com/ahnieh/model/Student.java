package com.ahnieh.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
	private String sid;
	private String sname;
	private String password;
	private String sex;
	private String classesno;
	private Date admissiondate;
	private Date birth;
	private String nativeplace;
	private String identifyno;
	private String political;
	private String mobilephone;
	private String nation;
	private String address;
	private String classesname;
	private String cid;
	private String score;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getClassesno() {
		return classesno;
	}
	public void setClassesno(String classesno) {
		this.classesno = classesno;
	}
	public Date getAdmissiondate() {
		return admissiondate;
	}
	public void setAdmissiondate(Date admissiondate) {
		this.admissiondate = admissiondate;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getNativeplace() {
		return nativeplace;
	}
	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}
	public String getIdentifyno() {
		return identifyno;
	}
	public void setIdentifyno(String identifyno) {
		this.identifyno = identifyno;
	}
	public String getPolitical() {
		return political;
	}
	public void setPolitical(String political) {
		this.political = political;
	}
	public String getMobilephone() {
		return mobilephone;
	}
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getClassesname() {
		return classesname;
	}
	public void setClassesname(String classesname) {
		this.classesname = classesname;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sb = new StringBuffer();
		sb.append("{\"sid\":\""+this.sid+"\"");
		sb.append(",\"sname\":\""+this.sname+"\"");
		sb.append(",\"classesname\":\""+this.classesname+"\"");
		sb.append(",\"admissiondate\":\""+sdf.format(this.admissiondate)+"\"");
		sb.append(",\"birth\":\""+sdf.format(this.birth)+"\"");
		sb.append(",\"nativeplace\":\""+this.nativeplace+"\"");
		sb.append(",\"identifyno\":\""+this.identifyno+"\"");
		sb.append(",\"political\":\""+this.political+"\"");
		sb.append(",\"mobilephone\":\""+this.mobilephone+"\"");
		sb.append(",\"nation\":\""+this.nation+"\"");
		sb.append(",\"address\":\""+this.address+"\"");
		sb.append(",\"cid\":\""+this.cid+"\"");
		sb.append(",\"score\":\""+this.score+"\"}");
		return sb.toString();
	}
}
