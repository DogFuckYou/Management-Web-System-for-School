package com.ahnieh.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CharacterEncodingFilter
 */
@WebFilter("*.do")
public class CharacterEncodingFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CharacterEncodingFilter() {
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
		String characterEncoding = request.getServletContext().getInitParameter("CharacterEncoding");
		((HttpServletResponse)response).setCharacterEncoding(characterEncoding);
		chain.doFilter(new HttpServletRequestWrapper((HttpServletRequest)request) {
			public String getParameter(String name) {
				String param = super.getParameter(name);
				try {
					if(param != null) {
						param = new String(param.getBytes("ISO8859-1"), characterEncoding);
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				return param;
			}

			@Override
			public String[] getParameterValues(String name) {
				String[] params = super.getParameterValues(name);
				try {
					if(params != null) {
						for(int i=0; i<params.length; i++) {
							params[i] = new String(params[i].getBytes("ISO8859-1"), characterEncoding);
						}
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				return params;
			}
			
		}, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
