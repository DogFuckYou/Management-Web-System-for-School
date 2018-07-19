package com.ahnieh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ahnieh.dao.StudentDao;
import com.ahnieh.model.Student;
import com.ahnieh.util.DBUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public void save(Student student) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			//3 操作数据库
			String sql = "update student set "
					+ "cid=?,score=? where sid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student.getCid());
			pstmt.setString(2, student.getScore());
			pstmt.setString(3, student.getSid());
			pstmt.executeUpdate();
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

	@Override
	public void saveAll(List<Student> studentList) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Student student) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			//3 操作数据库
			String sql = "delete from student where sid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student.getSid());
			pstmt.executeUpdate();
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

	@Override
	public void update(Student student) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			//3 操作数据库
			String sql = "update student set sname=?,"
					+ "cid=?,score=? where sid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student.getSname());
			pstmt.setString(2, student.getCid());
			pstmt.setString(3, student.getScore());
			pstmt.setString(4, student.getSid());
			pstmt.executeUpdate();
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

	@Override
	public Student query(String sid) throws SQLException {
		Student student = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			//3 操作数据库
		/*	String sql = "select s.*,(select classesname from classes c where c.classesno=s.classesno) "
					+ "classesname from student s where sid=?";*/
			String sql="select * from student";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				student = new Student();
				student.setSid(rs.getString("sid"));
				student.setSname(rs.getString("sname"));
				student.setCid(rs.getString("cid"));
				student.setScore(rs.getString("score"));
				
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
		return student;
	}

	@Override
	public List<Student> queryByCondition(String condition) throws SQLException {
		List<Student> studentList = new ArrayList<Student>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			//3 操作数据库
			String sql = "select s.*,(select classesname from classes c where c.classesno=s.classesno) classesname from student s where " + condition;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Student student = null;
			while(rs.next()) {
				student = new Student();
				student.setSid(rs.getString("sid"));
				student.setSname(rs.getString("sname"));
				student.setPassword(rs.getString("password"));
				student.setSex(rs.getString("sex"));
				student.setClassesno(rs.getString("classesno"));
				if(rs.getDate("admissiondate") != null) {
					student.setAdmissiondate(new Date(rs.getDate("admissiondate").getTime()));
				}
				if(rs.getDate("birth") != null) {
					student.setBirth(new Date(rs.getDate("birth").getTime()));
				}
				student.setNativeplace(rs.getString("nativeplace"));
				student.setIdentifyno(rs.getString("identifyno"));
				student.setPolitical(rs.getString("political"));
				student.setMobilephone(rs.getString("mobilephone"));
				student.setNation(rs.getString("nation"));
				student.setAddress(rs.getString("address"));
				student.setClassesname(rs.getString("classesname"));
				studentList.add(student);
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
		return studentList;
	}

	@Override
	public Student query(String sid, String password) throws SQLException {
		Student student = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			//3 操作数据库
			String sql = "select * from student where sid=? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sid);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				student = new Student();
				student.setSid(rs.getString("sid"));
				student.setSname(rs.getString("sname"));
				student.setPassword(rs.getString("password"));
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
		return student;
	}

	@Override
	public List<Student> queryByCondition(String condition, int page, int pageSize) throws SQLException {
		List<Student> studentList = new ArrayList<Student>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			//3 操作数据库
			String sql = "select s.*,(select classesname from classes c where c.classesno=s.classesno) "
					+ "classesname from student s where " + condition
					+ " limit ?, ?";//Mysql 分页查询
			/*
			select *
			  from (select rownum num,
			               s.*,
			               (select classesname
			                  from classes c
			                 where c.classesno = s.classesno) classesname
			          from student s
			         where 1 = 1) t
			 where t.num between 1 and 10;
			*///Oracle 分页查询
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page*pageSize);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			Student student = null;
			while(rs.next()) {
				student = new Student();
				student.setSid(rs.getString("sid"));
				student.setSname(rs.getString("sname"));
				student.setPassword(rs.getString("password"));
				student.setSex(rs.getString("sex"));
				student.setClassesno(rs.getString("classesno"));
				if(rs.getDate("admissiondate") != null) {
					student.setAdmissiondate(new Date(rs.getDate("admissiondate").getTime()));
				}
				if(rs.getDate("birth") != null) {
					student.setBirth(new Date(rs.getDate("birth").getTime()));
				}
				student.setNativeplace(rs.getString("nativeplace"));
				student.setIdentifyno(rs.getString("identifyno"));
				student.setPolitical(rs.getString("political"));
				student.setMobilephone(rs.getString("mobilephone"));
				student.setNation(rs.getString("nation"));
				student.setAddress(rs.getString("address"));
				student.setClassesname(rs.getString("classesname"));
				student.setCid(rs.getString("cid"));
				student.setScore(rs.getString("score"));
				studentList.add(student);
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
		return studentList;
	}

	@Override
	public int getCount(String condition) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			//3 操作数据库
			String sql = "select count(*) from student where " + condition;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
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
		return count;
	}
	
}
