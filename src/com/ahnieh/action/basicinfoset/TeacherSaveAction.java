package com.ahnieh.action.basicinfoset;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ahnieh.dao.TeacherDao;
import com.ahnieh.dao.impl.TeacherDaoImpl;
import com.ahnieh.model.Teacher;

/**
 * Servlet implementation class TeacherSaveAction
 */
@WebServlet("/basicinfoset/teachersave.do")
public class TeacherSaveAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherSaveAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String result="00";
		String tid=request.getParameter("tid");
		//É¾³ýÐÅÏ¢
		TeacherDao tDao=new TeacherDaoImpl();
		try {
			Teacher teacher=new Teacher();
			teacher.setTid(tid);
			tDao.delete(teacher);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			result="01";
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
