package com.ahnieh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ahnieh.dao.BaseCodeDao;
import com.ahnieh.model.BaseCode;
import com.ahnieh.util.DBUtil;

public class BaseCodeDaoImpl implements BaseCodeDao {

	@Override
	public void save(BaseCode baseCode) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			//3 操作数据库
			String sql = "insert into baseCode(codetype,codecode,codename) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, baseCode.getCodeType());
			pstmt.setString(2, baseCode.getCodeCode());
			pstmt.setString(3, baseCode.getCodeName());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//4 释放资源
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

	@Override
	public void saveAll(List<BaseCode> baseCodeList) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			//3 操作数据库
			String sql = "insert into baseCode(codetype,codecode,codename) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			for(BaseCode baseCode : baseCodeList) {
				pstmt.setString(1, baseCode.getCodeType());
				pstmt.setString(2, baseCode.getCodeCode());
				pstmt.setString(3, baseCode.getCodeName());
				pstmt.addBatch();
			}
			pstmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//4 释放资源
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

	@Override
	public void delete(BaseCode baseCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(BaseCode baseCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BaseCode query(String codetype, String codecode) {
		BaseCode baseCode = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			//3 操作数据库
			String sql = "select * from baseCode where uid=? and favcode=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, codetype);
			pstmt.setString(2, codecode);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				baseCode = new BaseCode();
				baseCode.setCodeType(rs.getString("codetype"));
				baseCode.setCodeCode(rs.getString("codecode"));
				baseCode.setCodeName(rs.getString("codename"));
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
		return baseCode;
	}

	@Override
	public List<BaseCode> queryByCondition(String condition) {
		List<BaseCode> baseCodeList = new ArrayList<BaseCode>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			//3 操作数据库
			String sql = "select * from baseCode where " + condition;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BaseCode baseCode = new BaseCode();
				baseCode.setCodeType(rs.getString("codetype"));
				baseCode.setCodeCode(rs.getString("codecode"));
				baseCode.setCodeName(rs.getString("codename"));
				baseCodeList.add(baseCode);
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
		return baseCodeList;
	}

}
