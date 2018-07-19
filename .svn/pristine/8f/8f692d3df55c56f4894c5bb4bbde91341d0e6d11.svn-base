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
@WebServlet("/basicinfoset/studentquery.do")
public class StudentQueryAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentQueryAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取查询条件
		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String page = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		int intPage = 1;
		int intPageSize = 10;
		if(page != null && !"".equals(page)) {
			intPage = Integer.parseInt(page);
		}
		if(pageSize != null && !"".equals(pageSize)) {
			intPageSize = Integer.parseInt(pageSize);
		}
		String condition = " 1=1 ";
		if(sid != null && !"".equals(sid)) {
			condition += " and sid = '"+sid+"'";
		}
		if(sname != null && !"".equals(sname)) {
			condition += " and sname like '%"+sname+"%'";
		}
		//查询学生信息
		StudentDao sDao = new StudentDaoImpl();
		/*try {
			List<Student> studentList = sDao.queryByCondition(condition,intPage-1,intPageSize);
			int totalCount = sDao.getCount(condition);
			request.setAttribute("studentList", studentList);
			request.setAttribute("totalCount", totalCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/basicinfoset/studentquery.jsp").forward(request, response);*/
		StringBuffer data= new StringBuffer();
		data.append("{");
		data.append("\"code\":0,");
		data.append("\"msg\":\"\",");
		try {
			List<Student> studentList = sDao.queryByCondition(condition,intPage-1,intPageSize);
			int totalCount = sDao.getCount(condition);
			data.append("\"count\":"+totalCount+",");
			data.append("\"data\":[");
			for(int i=0; i<studentList.size(); i++) {
				if(i == studentList.size()-1) {//最后一个元素
					data.append(studentList.get(i).toString());
				} else {
					data.append(studentList.get(i).toString()+",");
				}
			}
			data.append("]");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		data.append("}");
		System.out.println(data.toString());
		response.getWriter().write(data.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
