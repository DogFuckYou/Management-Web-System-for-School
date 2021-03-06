package com.ahnieh.dao;

import java.sql.SQLException;
import java.util.List;

import com.ahnieh.model.Student;
import com.ahnieh.model.Teacher;

public interface TeacherDao {
	public void save(Teacher teacher) throws SQLException;//保存用户信息
	public void saveAll(List<Teacher> teacherList) throws SQLException;//保存所有用户信息
	public void delete(Teacher teacher) throws SQLException;//按主键删除用户信息
	public void update(Teacher teacher) throws SQLException;//更改数据库User信息
	public void insert(Teacher teacher) throws SQLException;
	public Teacher query(String tid) throws SQLException;//按主键查询
	public Teacher query(String tid, String password) throws SQLException;
	public List<Teacher> queryByCondition(String condition) throws SQLException;//根据条件查询用户信息
	public List<Teacher> queryByCondition(String condition, int page, int pageSize) throws SQLException;//分页查询
	public int getCount(String condition);
}
