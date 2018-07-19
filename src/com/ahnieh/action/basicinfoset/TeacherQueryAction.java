package com.ahnieh.action.basicinfoset;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ahnieh.dao.TeacherDao;
import com.ahnieh.dao.impl.TeacherDaoImpl;
import com.ahnieh.model.Teacher;

/**
 * Servlet implementation class TeacherQueryAction
 */
@WebServlet("/basicinfoset/teacherquery.do")
public class TeacherQueryAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherQueryAction() {
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
		String tname = request.getParameter("tname");
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
		if(tid != null && !"".equals(tid)) {
			condition += " and tid = '"+tid+"'";
		}
		if(tname != null && !"".equals(tname)) {
			condition += " and tname like '%"+tname+"%'";
		}
		//查询教师信息
		TeacherDao tDao=new TeacherDaoImpl();
		StringBuffer data= new StringBuffer();
		data.append("{");
		data.append("\"code\":0,");
		data.append("\"msg\":\"\",");
		try {
			List<Teacher> teacherList=tDao.queryByCondition(condition,intPage-1,intPageSize);
			int totalCount=tDao.getCount(condition);
			data.append("\"count\":"+totalCount+",");
			data.append("\"data\":[");
			for (int i = 0; i < teacherList.size(); i++) {
				if (i == teacherList.size()-1) {
					data.append(teacherList.get(i).toString());
				}else {
					data.append(teacherList.get(i).toString()+",");
				}
			}
			data.append("]");
		} catch (SQLException e) {
			// TODO: handle exception
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
