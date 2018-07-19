package com.ahnieh.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ahnieh.dao.MenuDao;
import com.ahnieh.dao.UserDao;
import com.ahnieh.dao.impl.MenuDaoImpl;
import com.ahnieh.dao.impl.UserDaoImpl;
import com.ahnieh.model.MenuDto;
import com.ahnieh.model.User;
import com.ahnieh.util.MD5Util;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/logout.do")
public class LoginoutAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginoutAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//清除Session
		request.getSession().invalidate();
		//跳转至登录页面
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
