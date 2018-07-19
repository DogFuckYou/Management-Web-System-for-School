package com.ahnieh.dao;

import java.sql.SQLException;
import java.util.List;

import com.ahnieh.model.Menu;
import com.ahnieh.model.MenuDto;

public interface MenuDao {
	public void save(Menu menu) throws SQLException;//�����û���Ϣ
	public void saveAll(List<Menu> userList);//���������û���Ϣ
	public void delete(Menu menu);//������ɾ���û���Ϣ
	public void update(Menu menu);//�������ݿ�User��Ϣ
	public Menu query(String menuid);//��������ѯ
	public List<Menu> queryByCondition(String condition);//����������ѯ�û���Ϣ
	public List<MenuDto> getUserMenu(String usercode);
}
