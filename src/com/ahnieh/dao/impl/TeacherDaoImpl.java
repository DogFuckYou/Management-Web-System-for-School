package com.ahnieh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ahnieh.dao.TeacherDao;
import com.ahnieh.model.Student;
import com.ahnieh.model.Teacher;
import com.ahnieh.util.DBUtil;

public class TeacherDaoImpl implements TeacherDao {

	@Override
	public void save(Teacher teacher) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAll(List<Teacher> teacherList) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Teacher teacher) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			//3 操作数据库
			String sql = "delete from teacher where tid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teacher.getTid());
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
	public void update(Teacher teacher) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			//3 操作数据库
			String sql = "update teacher set tname=?,password=?,sex=?,professionalno=?,ProfessionalTitle=?,nativeplace=?,identifyno=?,political=?,mobilephone=?,nation=?,address=? where tid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teacher.getTname());
			pstmt.setString(2, teacher.getPassword());
			pstmt.setString(3, teacher.getSex());
			pstmt.setString(4, teacher.getProfessionalno());
			pstmt.setString(5, teacher.getProfessionalTitle());
			pstmt.setString(6, teacher.getNativeplace());
			pstmt.setString(7, teacher.getIdentifyno());
			pstmt.setString(8, teacher.getPolitical());
			pstmt.setString(9, teacher.getMobilephone());
			pstmt.setString(10, teacher.getNation());
			pstmt.setString(11, teacher.getAddress());
			pstmt.setString(12, teacher.getTid());
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
	public Teacher query(String tid) throws SQLException {
		Teacher teacher = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			//3 操作数据库
			String sql = "select * from teacher where tid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				teacher = new Teacher();
				teacher.setTid(rs.getString("tid"));
				teacher.setTname(rs.getString("tname"));
				teacher.setPassword(rs.getString("password"));
				teacher.setSex(rs.getString("sex"));
				teacher.setProfessionalno(rs.getString("professionalno"));
				teacher.setProfessionalTitle(rs.getString("ProfessionalTitle"));
				teacher.setNativeplace(rs.getString("nativeplace"));
				teacher.setIdentifyno(rs.getString("identifyno"));
				teacher.setPolitical(rs.getString("political"));
				teacher.setMobilephone(rs.getString("mobilephone"));
				teacher.setNation(rs.getString("nation"));
				teacher.setAddress(rs.getString("address"));
				teacher.setIntroduce(rs.getString("introduce"));
				teacher.setImage(rs.getString("image"));
				
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
		return teacher;
	}

	@Override
	public List<Teacher> queryByCondition(String condition) throws SQLException {
		// TODO Auto-generated method stub
		List<Teacher> teacherList = new ArrayList<Teacher>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			//3 操作数据库
			String sql = "select *  from teacher where "
			+ condition;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Teacher teacher = null;
			while(rs.next()) {
				teacher=new Teacher();
				teacher.setTid("tid");
				teacher.setTname("tname");
				teacher.setPassword("password");
				teacher.setSex("sex");
				teacher.setProfessionalno("professionalno");
				teacher.setProfessionalTitle("ProfessionalTitle");
				teacher.setNativeplace("nativeplace");
				teacher.setIdentifyno("identifyno");
				teacher.setPolitical("political");
				teacher.setMobilephone("mobilephone");
				teacher.setNation("nation");
				teacher.setAddress("address");
				teacher.setIntroduce("introduce");
				teacher.setImage("image");
				teacherList.add(teacher);
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
		return teacherList;
	}

	@Override
	public Teacher query(String tid, String password) throws SQLException {
		Teacher teacher = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			//3 操作数据库
			String sql = "select * from teacher where tid=? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tid);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				teacher = new Teacher();
				teacher.setTid(rs.getString("tid"));
				teacher.setTname(rs.getString("tname"));
				teacher.setPassword(rs.getString("password"));
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
		return teacher;
	}

	@Override
	public List<Teacher> queryByCondition(String condition, int page, int pageSize) throws SQLException {
		// TODO Auto-generated method stub
		List<Teacher> teacherList=new ArrayList<Teacher>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from teacher where " + condition
				+ " limit ?, ?";//Mysql分页查询
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, page*pageSize);
			pstmt.setInt(2, pageSize);
			rs=pstmt.executeQuery();
			Teacher teacher=null;
			while(rs.next()) {
				teacher=new Teacher();
				teacher.setTid(rs.getString("tid"));
				teacher.setTname(rs.getString("tname"));
				teacher.setPassword(rs.getString("password"));
				teacher.setSex(rs.getString("sex"));
				teacher.setProfessionalno(rs.getString("professionalno"));
				teacher.setProfessionalTitle(rs.getString("ProfessionalTitle"));
				teacher.setNativeplace(rs.getString("nativeplace"));
				teacher.setIdentifyno(rs.getString("identifyno"));
				teacher.setPolitical(rs.getString("political"));
				teacher.setMobilephone(rs.getString("mobilephone"));
				teacher.setNation(rs.getString("nation"));
				teacher.setAddress(rs.getString("address"));
				teacher.setIntroduce(rs.getString("introduce"));
				teacher.setImage(rs.getString("image"));
				teacherList.add(teacher);
			
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
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
		
		return teacherList;
	}

	@Override
	public int getCount(String condition) {
		// TODO Auto-generated method stub
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			//3 操作数据库
			String sql = "select count(*) from teacher where " + condition;
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

	@Override
	public void insert(Teacher teacher) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			//3 操作数据库
			String sql = "insert into teacher (tid,tname,password,sex,professionalno,ProfessionalTitle,nativeplace,identifyno,political,mobilephone,nation,address)"
			+" values (?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teacher.getTid());
			pstmt.setString(2, teacher.getTname());
			pstmt.setString(3, teacher.getPassword());
			pstmt.setString(4, teacher.getSex());
			pstmt.setString(5, teacher.getProfessionalno());
			pstmt.setString(6, teacher.getProfessionalTitle());
			pstmt.setString(7, teacher.getNativeplace());
			pstmt.setString(8, teacher.getIdentifyno());
			pstmt.setString(9, teacher.getPolitical());
			pstmt.setString(10, teacher.getMobilephone());
			pstmt.setString(11, teacher.getNation());
			pstmt.setString(12, teacher.getAddress());
			pstmt.executeUpdate();
			System.out.println(teacher.toString());
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
