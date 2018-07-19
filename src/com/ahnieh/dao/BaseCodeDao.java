package com.ahnieh.dao;

import java.util.List;

import com.ahnieh.model.BaseCode;

public interface BaseCodeDao {
	public void save(BaseCode baseCode);//�����û���Ϣ
	public void saveAll(List<BaseCode> userList);//���������û���Ϣ
	public void delete(BaseCode baseCode);//������ɾ���û���Ϣ
	public void update(BaseCode baseCode);//�������ݿ�User��Ϣ
	public BaseCode query(String codetype, String codecode);//��������ѯ
	public List<BaseCode> queryByCondition(String condition);//����������ѯ�û���Ϣ
}
