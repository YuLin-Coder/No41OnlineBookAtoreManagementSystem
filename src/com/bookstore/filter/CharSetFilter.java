package com.bookstore.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//使用中文乱码处理过滤器
public class CharSetFilter implements Filter{

	private String charSet = "gbk";
	public void init(FilterConfig config) throws ServletException {
		charSet = config.getInitParameter("charSet");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//中文乱码处理
		request.setCharacterEncoding(charSet);
		chain.doFilter(request, response);
	}

	public void destroy() {
		
	}
}

