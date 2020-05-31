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

//�G�pFilter�P���wurlPattern���V�����ؿ�acct
@WebFilter(urlPatterns= {"/acct/*"})
public class AuthorizationFilter implements Filter {
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		//�P�_��ݬO�_���w��ӫe�ݫ���Session���Acred
		if(httpRequest.getSession().getAttribute("cred")==null) {
			//�D�k�i�J(�|���n�J)
			((HttpServletResponse)response).sendRedirect("../login.html");;
		}
		chain.doFilter(request, response);
	}
}
