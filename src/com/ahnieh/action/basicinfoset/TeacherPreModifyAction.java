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
 * Servlet implementation class TeacherPreModifyAction
 */
@WebServlet("/basicinfoset/teacherpremodify.do")
public class TeacherPreModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherPreModifyAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				//获取查询条件
				String tid = request.getParameter("tid");
				//查询教师信息
				TeacherDao tDao = new TeacherDaoImpl();
				try {
					Teacher teacher = tDao.query(tid);
					request.setAttribute("teacher", teacher);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.getRequestDispatcher("/basicinfoset/teachermodify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
