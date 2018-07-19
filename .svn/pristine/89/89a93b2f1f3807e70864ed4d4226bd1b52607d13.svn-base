package com.ahnieh.dao;

import java.sql.SQLException;
import java.util.List;

import com.ahnieh.model.Menu;
import com.ahnieh.model.MenuDto;

public interface MenuDao {
	public void save(Menu menu) throws SQLException;//保存用户信息
	public void saveAll(List<Menu> userList);//保存所有用户信息
	public void delete(Menu menu);//按主键删除用户信息
	public void update(Menu menu);//更改数据库User信息
	public Menu query(String menuid);//按主键查询
	public List<Menu> queryByCondition(String condition);//根据条件查询用户信息
	public List<MenuDto> getUserMenu(String usercode);
}
