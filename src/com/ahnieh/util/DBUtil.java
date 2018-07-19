package com.ahnieh.util;

import java.io.File;
import java.sql.*;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DBUtil {
	
	public static void main(String[] args) {
		System.out.println("com.mysql.jdbc.DRIVER");
	}
	
	private static String URL = "";
	private static String DRIVER = "";
	private static String USER = "";
	private static String PASSWORD = "";
	
	static {
		try {
			//��ȡ�����ļ�
			readDBInfo();
			//1 ��������
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//��ȡjdbc������Ϣ
	public static void readDBInfo() {
		//1 ��ȡ����XML��SAXReader��
		String filePath = 
				DBUtil.class.getClassLoader().
				getResource("jdbc.xml").getPath();
		File docFile = new File(filePath);
		try {
			Document doc = new SAXReader().read(docFile);
			for(Element e : (List<Element>)(doc.getRootElement().elements())) {
				if("url".equals(e.getName())) {
					URL = e.getText();
				} else if ("driver".equals(e.getName())) {
					DRIVER = e.getText();
					System.out.println(DRIVER);
				} else if ("user".equals(e.getName())) {
					USER = e.getText();
				} else if ("password".equals(e.getName())) {
					PASSWORD = e.getText();
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		//2 ��ȡ����
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
