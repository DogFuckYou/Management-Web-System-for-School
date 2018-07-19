package com.ahnieh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ahnieh.dao.SCDao;
import com.ahnieh.model.SC;
import com.ahnieh.util.DBUtil;

/**
*@author xxxxf 
*2018年6月30日
*/
public class SCDaoImpl implements SCDao{

	@Override
	public void insert(SC sc) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			// 操作数据库
			String sql = "insert into sc (sid,cid,cname,score) values (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sc.getSid());
			pstmt.setString(2, sc.getCid());
			pstmt.setString(3, sc.getCname());
			pstmt.setString(4, sc.getScore());
			pstmt.executeUpdate();
			System.out.println(sc.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//4 释放资源
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

	}

}
