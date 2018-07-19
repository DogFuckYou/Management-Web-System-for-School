package com.ahnieh.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ahnieh.model.User;

/**
 * Servlet Filter implementation class CheckUserFilter
 */
@WebFilter(urlPatterns = {"*.do", "*.jsp"})
public class CheckUserFilter implements Filter {
	private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
	        Arrays.asList("login", "logout", "register","check")));


    /**
     * Default constructor. 
     */
    public CheckUserFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		//需要对用户登录请求进行放行
		if(isExcluded(httpRequest)) {//不需要进行用户登录校验的请求
			chain.doFilter(request, response);
		} else {
			User user = (User)httpRequest.getSession().getAttribute("user");
			if(user == null) {//未在session中获取用户信息
				httpRequest.getRequestDispatcher("/").forward(httpRequest, httpResponse);
			} else {
				chain.doFilter(httpRequest, httpResponse);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		fConfig.getInitParameter("param");
	}
	
	boolean isExcluded(HttpServletRequest request) {
        String path = request.getRequestURI();
        if(path.lastIndexOf('.')==-1) {//访问的是应用根路径，直接放行
        	return true;
        }
        String urlPattern = path.substring(path.lastIndexOf('/')+1, path.lastIndexOf('.'));
        return ALLOWED_PATHS.contains(urlPattern);
    }

}
