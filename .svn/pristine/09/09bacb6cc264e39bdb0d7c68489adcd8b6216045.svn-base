package com.ahnieh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ahnieh.dao.MenuDao;
import com.ahnieh.model.Menu;
import com.ahnieh.model.MenuDto;
import com.ahnieh.util.DBUtil;

public class MenuDaoImpl implements MenuDao {
	
	@Override
	public void save(Menu menu) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			//3 操作数据库
			String sql = "insert into menu(menuid,menuname,url,menulevel,displayno,taskcode) "
					+ "values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menu.getMenuid());
			pstmt.setString(2, menu.getMenuname());
			pstmt.setString(3, menu.getUrl());
			pstmt.setInt(4, menu.getMenulevel());
			pstmt.setInt(5, menu.getDisplayno());
			pstmt.setString(6, menu.getTaskcode());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
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
	public void saveAll(List<Menu> userList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Menu menu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Menu menu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Menu query(String uid) {
		Menu menu = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			//3 操作数据库
			String sql = "select * from menu where menuid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				menu = new Menu();
				menu.setMenuid(rs.getString("menuid"));
				menu.setMenuname(rs.getString("menuname"));
				menu.setUrl(rs.getString("url"));
				menu.setMenulevel(rs.getInt("menulevel"));
				menu.setDisplayno(rs.getInt("displayno"));
				menu.setTaskcode(rs.getString("taskcode"));
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
		return menu;
	}

	@Override
	public List<Menu> queryByCondition(String condition) {
		List<Menu> userList = new ArrayList<Menu>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			//3 操作数据库
			String sql = "select * from menu where " + condition;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Menu menu = new Menu();
				menu.setMenuid(rs.getString("menuid"));
				menu.setMenuname(rs.getString("menuname"));
				menu.setUrl(rs.getString("url"));
				menu.setMenulevel(rs.getInt("menulevel"));
				menu.setDisplayno(rs.getInt("displayno"));
				menu.setTaskcode(rs.getString("taskcode"));
				userList.add(menu);
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
		return userList;
	}

	@Override
	public List<MenuDto> getUserMenu(String usercode) {
		List<MenuDto> menuList = new ArrayList<MenuDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			//3 操作数据库
			StringBuffer sf = new StringBuffer();
			sf.append("select m.menuid,m.menulevel,m.menuname,m.url, m.taskcode,t.uppertaskcode ");
			sf.append(" from niehmenu m, niehusergrade ug, niehgradetask gt, niehtask t");
			sf.append(" where m.taskcode = gt.taskcode");
			sf.append("  and ug.gradecode = gt.gradecode");
			sf.append("  and gt.taskcode = t.taskcode");
			sf.append("  and ug.usercode=?");
			sf.append(" order by m.menulevel, m.displayno");
			pstmt = conn.prepareStatement(sf.toString());
			pstmt.setString(1, usercode);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MenuDto menu = new MenuDto();
				menu.setMenuid(rs.getString("menuid"));
				menu.setMenulevel(rs.getInt("menulevel"));
				menu.setMenuname(rs.getString("menuname"));
				menu.setUrl(rs.getString("url"));
				menu.setTaskcode(rs.getString("taskcode"));
				menu.setUppertaskcode(rs.getString("uppertaskcode"));
				//梳理菜单层级关系
				if(menu.getMenulevel() == 1) {
					menuList.add(menu);
				} else {//菜单只有两个层级
					for(MenuDto m : menuList) {
						if(m.getTaskcode().equals(menu.getUppertaskcode())) {
							m.getMenuDtoList().add(menu);
							break;
						}
					}
				}
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
		return menuList;
	}
	
}
