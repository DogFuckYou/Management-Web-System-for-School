package com.ahnieh.model;

import java.util.ArrayList;
import java.util.List;

public class MenuDto {//�Զ���ļ�Java��
	private int menulevel;
	private String menuid;
	private String menuname;
	private String url;
	private String taskcode;
	private String uppertaskcode;
	
	private List<MenuDto> menuDtoList = new ArrayList<MenuDto>();//�Ӽ��˵�
	
	public String getMenuid() {
		return menuid;
	}
	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}
	public int getMenulevel() {
		return menulevel;
	}
	public void setMenulevel(int menulevel) {
		this.menulevel = menulevel;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTaskcode() {
		return taskcode;
	}
	public void setTaskcode(String taskcode) {
		this.taskcode = taskcode;
	}
	public String getUppertaskcode() {
		return uppertaskcode;
	}
	public void setUppertaskcode(String uppertaskcode) {
		this.uppertaskcode = uppertaskcode;
	}
	public List<MenuDto> getMenuDtoList() {
		return menuDtoList;
	}
	public void setMenuDtoList(List<MenuDto> menuDtoList) {
		this.menuDtoList = menuDtoList;
	}
}
