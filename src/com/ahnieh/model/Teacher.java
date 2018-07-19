package com.ahnieh.model;

import java.text.SimpleDateFormat;

public class Teacher {
	private String tid;
	private String tname;
	private String password;
	private String sex;
	private String professionalno;
	private String professionalTitle;
	private String nativeplace;
	private String identifyno;
	private String political;
	private String mobilephone;
	private String nation;
	private String address;
	private String introduce;
	private String image;
	
	
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
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
	public String getProfessionalno() {
		return professionalno;
	}
	public void setProfessionalno(String professionalno) {
		this.professionalno = professionalno;
	}
	public String getProfessionalTitle() {
		return professionalTitle;
	}
	public void setProfessionalTitle(String professionalTitle) {
		this.professionalTitle = professionalTitle;
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
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("{\"tid\":\""+this.tid+"\"");
		sb.append(",\"tname\":\""+this.tname+"\"");
		sb.append(",\"sex\":\""+this.sex+"\"");
		sb.append(",\"professionalno\":\""+this.professionalno+"\"");
		sb.append(",\"ProfessionalTitle\":\""+this.professionalTitle+"\"");
		sb.append(",\"nativeplace\":\""+this.nativeplace+"\"");
		sb.append(",\"identifyno\":\""+this.identifyno+"\"");
		sb.append(",\"political\":\""+this.political+"\"");
		sb.append(",\"mobilephone\":\""+this.mobilephone+"\"");
		sb.append(",\"nation\":\""+this.nation+"\"");
		sb.append(",\"address\":\""+this.address+"\"}");
		return sb.toString();
	}
	
}
