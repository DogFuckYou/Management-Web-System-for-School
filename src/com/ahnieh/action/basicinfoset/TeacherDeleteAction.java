package com.ahnieh.action.basicinfoset;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ahnieh.dao.StudentDao;
import com.ahnieh.dao.TeacherDao;
import com.ahnieh.dao.impl.StudentDaoImpl;
import com.ahnieh.dao.impl.TeacherDaoImpl;
import com.ahnieh.model.Student;
import com.ahnieh.model.Teacher;

/**
 * Servlet implementation class TeacherDeleteAction
 */
@WebServlet("/basicinfoset/teacherdel.do")
public class TeacherDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherDeleteAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String result = "00";//默认返回结果
		//获取查询条件
		String tid = request.getParameter("tid");
		//删除学生信息
		TeacherDao tDao = new TeacherDaoImpl();
		try {
			Teacher teacher = new Teacher();
			teacher.setTid(tid);
			tDao.delete(teacher);
		} catch (SQLException e) {
			e.printStackTrace();
			result = "01";
		}
		response.getWriter().write(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
