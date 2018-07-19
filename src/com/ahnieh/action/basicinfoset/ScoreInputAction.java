package com.ahnieh.action.basicinfoset;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ahnieh.dao.SCDao;

import com.ahnieh.dao.impl.SCDaoImpl;

import com.ahnieh.model.SC;


/**
 * Servlet implementation class TeacherInsertAction
 */
@WebServlet("/basicinfoset/scoreinput.do")
public class ScoreInputAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreInputAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sid=request.getParameter("sid");
		String cid=request.getParameter("cid");
		String cname=request.getParameter("cname");
		String score=request.getParameter("score");
		
	
		//把数据插到对象的属性中
		SCDao scDao=new SCDaoImpl();
		SC sc=new SC();
		sc.setSid(sid);
		sc.setCid(cid);
		sc.setCname(cname);
		sc.setScore(score);
		try {
			scDao.insert(sc);
			System.out.println(sc.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//跳转至消息页面
		request.setAttribute("message", "成绩录入成功！");
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
