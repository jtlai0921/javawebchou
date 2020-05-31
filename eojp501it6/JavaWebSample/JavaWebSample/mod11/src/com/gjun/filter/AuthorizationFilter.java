package com.gjun.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//佈署Filter與指定urlPattern指向虛擬目錄acct
@WebFilter(urlPatterns= {"/acct/*"})
public class AuthorizationFilter implements Filter {
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		//判斷後端是否有針對該前端持續的Session狀態cred
		if(httpRequest.getSession().getAttribute("cred")==null) {
			//非法進入(尚未登入)
			((HttpServletResponse)response).sendRedirect("../login.html");;
		}
		chain.doFilter(request, response);
	}
}
