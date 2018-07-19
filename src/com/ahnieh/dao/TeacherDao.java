package com.ahnieh.dao;

import java.sql.SQLException;
import java.util.List;

import com.ahnieh.model.Student;
import com.ahnieh.model.Teacher;

public interface TeacherDao {
	public void save(Teacher teacher) throws SQLException;//�����û���Ϣ
	public void saveAll(List<Teacher> teacherList) throws SQLException;//���������û���Ϣ
	public void delete(Teacher teacher) throws SQLException;//������ɾ���û���Ϣ
	public void update(Teacher teacher) throws SQLException;//�������ݿ�User��Ϣ
	public void insert(Teacher teacher) throws SQLException;
	public Teacher query(String tid) throws SQLException;//��������ѯ
	public Teacher query(String tid, String password) throws SQLException;
	public List<Teacher> queryByCondition(String condition) throws SQLException;//����������ѯ�û���Ϣ
	public List<Teacher> queryByCondition(String condition, int page, int pageSize) throws SQLException;//��ҳ��ѯ
	public int getCount(String condition);
}
