package com.gjun.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

//@WebFilter(
//		urlPatterns = { "/hr/*" }, 
//		initParams = { 
//				@WebInitParam(name = "target", value = "�H�Ƹ귽�t��")
//		},
//		dispatcherTypes= {DispatcherType.REQUEST,
//				DispatcherType.FORWARD,
//				DispatcherType.INCLUDE}
//		)
public class HRSecurityHandler implements Filter {


    public HRSecurityHandler() {
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		//�ѦҥX�e�ݪ�Cookie
		boolean r=false;
		Cookie[] cookies=((HttpServletRequest)request).getCookies();
		if(cookies!=null) {
			//���yCookie�O�_�㦳����������
			for(Cookie cookie:cookies) {
				//�e�ݾ���Cookie name�w�q��cred
				if(cookie.getName().equals("cred")) { 
					r=true;
					break;
				}
			}
		}
		//�P�_�O�_������ �p�G�����U�쵲
		if(r) {
		chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
