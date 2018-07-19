package com.ahnieh.dao;

import java.sql.SQLException;
import java.util.List;

import com.ahnieh.model.Student;

public interface StudentDao {
	public void save(Student student) throws SQLException;//保存用户信息
	public void saveAll(List<Student> studentList) throws SQLException;//保存所有用户信息
	public void delete(Student student) throws SQLException;//按主键删除用户信息
	public void update(Student student) throws SQLException;//更改数据库User信息
	public Student query(String sid) throws SQLException;//按主键查询
	public Student query(String sid, String password) throws SQLException;
	public List<Student> queryByCondition(String condition) throws SQLException;//根据条件查询用户信息
	public List<Student> queryByCondition(String condition, int page, int pageSize) throws SQLException;//分页查询
	public int getCount(String condition);
}
