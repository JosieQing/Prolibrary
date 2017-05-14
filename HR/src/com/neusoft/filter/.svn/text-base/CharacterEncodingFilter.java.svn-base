package com.neusoft.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * Filter:过滤字符编码（转码）
 */
public class CharacterEncodingFilter implements Filter{
	private String encoding ="ISO8859-1";
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//如何还有下一个Filter的话，那么就交给下一个Filter来处理，如果没有Filter，就会调用Servlet
		System.out.println("1111111111111111111111111111111111111111111");
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig config) throws ServletException {
		//获取初始化参数(web.xml)
		encoding = config.getInitParameter("encoding");
		
	}

}
