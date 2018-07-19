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
 * Servlet implementation class CheckAction
 */
@WebServlet("/check.do")
public class CheckAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String checkResult = "";
		String checkType = request.getParameter("checkType");
		if("userinfo".equals(checkType)) {//校验用户名/密码是否正确，同时校验用户是否有登录系统的权限
			checkResult = "00";
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String usertype = request.getParameter("usertype");
			UserDao userDao = new UserDaoImpl();
			try {
				User user = userDao.checkUser(username, MD5Util.getMD5(password), usertype);
				if(user.getAdmin()==null && user.getStudent()==null && user.getTeacher()==null) {
					checkResult = "01";//表示用户名或密码错误
				} else {//校验用户是否有登录权限
					MenuDao menuDao = new MenuDaoImpl();
					List<MenuDto> menuDtoList = menuDao.getUserMenu(username);
					if(menuDtoList.size()==0) {
						checkResult = "02";//表示用户无系统登录权限
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.getWriter().write(checkResult);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
