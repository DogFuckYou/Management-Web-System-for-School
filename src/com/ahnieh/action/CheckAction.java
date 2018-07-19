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
		if("userinfo".equals(checkType)) {//У���û���/�����Ƿ���ȷ��ͬʱУ���û��Ƿ��е�¼ϵͳ��Ȩ��
			checkResult = "00";
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String usertype = request.getParameter("usertype");
			UserDao userDao = new UserDaoImpl();
			try {
				User user = userDao.checkUser(username, MD5Util.getMD5(password), usertype);
				if(user.getAdmin()==null && user.getStudent()==null && user.getTeacher()==null) {
					checkResult = "01";//��ʾ�û������������
				} else {//У���û��Ƿ��е�¼Ȩ��
					MenuDao menuDao = new MenuDaoImpl();
					List<MenuDto> menuDtoList = menuDao.getUserMenu(username);
					if(menuDtoList.size()==0) {
						checkResult = "02";//��ʾ�û���ϵͳ��¼Ȩ��
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
