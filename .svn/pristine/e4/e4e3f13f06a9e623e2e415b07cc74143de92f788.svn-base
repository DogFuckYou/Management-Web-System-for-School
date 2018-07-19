package com.ahnieh.action.basicinfoset;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ahnieh.dao.StudentDao;
import com.ahnieh.dao.impl.StudentDaoImpl;
import com.ahnieh.model.Student;

/**
 * Servlet implementation class StudentQueryAction
 */
@WebServlet("/basicinfoset/studentsave.do")
public class StudentSaveAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSaveAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = "00";//默认返回结果
		//获取查询条件
		String sid = request.getParameter("sid");
		//删除学生信息
		StudentDao sDao = new StudentDaoImpl();
		try {
			Student student = new Student();
			student.setSid(sid);
			sDao.delete(student);
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
