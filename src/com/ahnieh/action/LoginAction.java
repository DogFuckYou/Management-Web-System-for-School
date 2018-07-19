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
@WebServlet("/login.do")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String usertype = request.getParameter("usertype");
		System.out.println(username);
		User user = null;
		if("1".equals(usertype) || "2".equals(usertype) || "3".equals(usertype)) {
			UserDao userDao = new UserDaoImpl();
			try {
				user = userDao.checkUser(username, MD5Util.getMD5(password), usertype);
				if(user.getAdmin()==null && user.getStudent()==null && user.getTeacher()==null) {//校验失败
					request.setAttribute("message", "用户名或密码错误，请重试！");
					request.getRequestDispatcher("/common/error.jsp").forward(request, response);
					return;
				}
				MenuDao menuDao = new MenuDaoImpl();
				List<MenuDto> menuDtoList = menuDao.getUserMenu(username);
				request.getSession().setAttribute("user", user);
				request.setAttribute("menuDtoList", menuDtoList);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {//非法参数
			request.setAttribute("message", "非法用户类型，请重试！");
			request.getRequestDispatcher("/common/error.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
