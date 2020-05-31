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
//				@WebInitParam(name = "target", value = "人事資源系統")
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
		//參考出前端的Cookie
		boolean r=false;
		Cookie[] cookies=((HttpServletRequest)request).getCookies();
		if(cookies!=null) {
			//掃描Cookie是否具有相關的憑證
			for(Cookie cookie:cookies) {
				//前端憑證Cookie name定義為cred
				if(cookie.getName().equals("cred")) { 
					r=true;
					break;
				}
			}
		}
		//判斷是否有憑證 如果有往下鏈結
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
