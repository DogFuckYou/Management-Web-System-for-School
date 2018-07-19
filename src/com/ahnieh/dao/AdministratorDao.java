package com.ahnieh.dao;

import java.sql.SQLException;
import java.util.List;

import com.ahnieh.model.Administrator;

public interface AdministratorDao {
	public void save(Administrator admin) throws SQLException;//保存用户信息
	public void saveAll(List<Administrator> adminList) throws SQLException;//保存所有用户信息
	public void delete(Administrator admin) throws SQLException;//按主键删除用户信息
	public void update(Administrator admin) throws SQLException;//更改数据库User信息
	public Administrator query(String aid) throws SQLException;//按主键查询
	public Administrator query(String aid, String password) throws SQLException;//按用户名和密码查询
	public List<Administrator> queryByCondition(String condition) throws SQLException;//根据条件查询用户信息
}
