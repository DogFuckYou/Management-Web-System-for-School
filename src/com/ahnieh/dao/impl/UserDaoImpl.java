package com.ahnieh.dao.impl;

import java.sql.SQLException;

import com.ahnieh.dao.AdministratorDao;
import com.ahnieh.dao.StudentDao;
import com.ahnieh.dao.TeacherDao;
import com.ahnieh.dao.UserDao;
import com.ahnieh.model.Administrator;
import com.ahnieh.model.Student;
import com.ahnieh.model.Teacher;
import com.ahnieh.model.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User checkUser(String uid, String password, String usertype) 
			throws SQLException {
		User user = new User();
		user.setUsertype(usertype);
		if("1".equals(usertype)) {// 管理员登录
			AdministratorDao adminDao = new AdministratorDaoImpl();
			Administrator admin = adminDao.query(uid, password);
			if(admin != null) {
				user.setAdmin(admin);
				user.setUsername(admin.getAname());
			}
		} else if("2".equals(usertype)) {// 教师登录
			TeacherDao teacherDao = new TeacherDaoImpl();
			Teacher teacher = teacherDao.query(uid, password);
			if(teacher != null) {
				user.setTeacher(teacher);
				user.setUsername(teacher.getTname());
			}
		} else if("3".equals(usertype)) {// 学生登录
			StudentDao studentDao = new StudentDaoImpl();
			Student student = studentDao.query(uid, password);
			if(student != null) {
				user.setStudent(student);
				user.setUsername(student.getSname());
			}
		}
		return user;
	}

}
