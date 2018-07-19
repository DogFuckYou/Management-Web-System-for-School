package com.ahnieh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ahnieh.dao.AdministratorDao;
import com.ahnieh.model.Administrator;
import com.ahnieh.util.DBUtil;

public class AdministratorDaoImpl implements AdministratorDao {

	@Override
	public void save(Administrator admin) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAll(List<Administrator> adminList) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Administrator admin) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Administrator admin) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Administrator query(String aid) throws SQLException {
		Administrator admin = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			//3 操作数据库
			String sql = "select * from administrator where aid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				admin = new Administrator();
				admin.setAid(rs.getString("aid"));
				admin.setAname(rs.getString("aname"));
				admin.setPassword(rs.getString("password"));
			}
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
		return admin;
	}

	@Override
	public List<Administrator> queryByCondition(String condition) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Administrator query(String aid, String password) throws SQLException {
		Administrator admin = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			//3 操作数据库
			String sql = "select * from administrator where aid=? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aid);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				admin = new Administrator();
				admin.setAid(rs.getString("aid"));
				admin.setAname(rs.getString("aname"));
				admin.setPassword(rs.getString("password"));
			}
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
		return admin;
	}
	
}
