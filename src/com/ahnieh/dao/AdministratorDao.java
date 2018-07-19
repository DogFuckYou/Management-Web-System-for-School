package com.ahnieh.dao;

import java.sql.SQLException;
import java.util.List;

import com.ahnieh.model.Administrator;

public interface AdministratorDao {
	public void save(Administrator admin) throws SQLException;//�����û���Ϣ
	public void saveAll(List<Administrator> adminList) throws SQLException;//���������û���Ϣ
	public void delete(Administrator admin) throws SQLException;//������ɾ���û���Ϣ
	public void update(Administrator admin) throws SQLException;//�������ݿ�User��Ϣ
	public Administrator query(String aid) throws SQLException;//��������ѯ
	public Administrator query(String aid, String password) throws SQLException;//���û����������ѯ
	public List<Administrator> queryByCondition(String condition) throws SQLException;//����������ѯ�û���Ϣ
}
