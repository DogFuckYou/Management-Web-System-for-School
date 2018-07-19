package com.ahnieh.model;

import java.text.SimpleDateFormat;

/**
*@author xxxxf 
*2018Äê6ÔÂ30ÈÕ
*/
public class SC {
	private String sid;
	private String cid;
	private String cname;
	private String score;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("{\"sid\":\""+this.sid+"\"");
		sb.append(",\"cid\":\""+this.cid+"\"");
		sb.append(",\"cname\":\""+this.cname+"\"");
		sb.append(",\"score\":\""+this.score+"\"}");
		return sb.toString();
	}

}
