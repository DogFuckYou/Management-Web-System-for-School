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
 * Servlet implementation class TeacherInsertAction
 */
@WebServlet("/basicinfoset/teacherinsert.do")
public class TeacherInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherInsertAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tid=request.getParameter("tid");
		String tname=request.getParameter("tname");
		String password=request.getParameter("password");
		String sex=request.getParameter("sex");
		String professionalno=request.getParameter("professionalno");		
		String professionalTitle=request.getParameter("professionalTitle");
		String nativeplace=request.getParameter("nativeplace");
		String identifyno=request.getParameter("identifyno");
		String political=request.getParameter("political");
		String mobilephone=request.getParameter("mobilephone");
		String nation=request.getParameter("nation");
		String address=request.getParameter("address");
	
		//把数据插到对象的属性中
		TeacherDao tDao=new TeacherDaoImpl();
		Teacher teacher=new Teacher();
		teacher.setTid(tid);
		teacher.setTname(tname);
		teacher.setPassword(password);
		teacher.setSex(sex);
		teacher.setProfessionalno(professionalno);
		teacher.setProfessionalTitle(professionalTitle);
		teacher.setNativeplace(nativeplace);
		teacher.setIdentifyno(identifyno);
		teacher.setPolitical(political);
		teacher.setMobilephone(mobilephone);
		teacher.setNation(nation);
		teacher.setAddress(address);
		try {
			tDao.insert(teacher);
			System.out.println(teacher.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//跳转至消息页面
		request.setAttribute("message", "教师信息新增成功！");
		request.getRequestDispatcher("/common/success.jsp").forward(request, response);
		
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
