package com.gjun.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


//��@Filter����
public class EncoderHandler implements Filter {
   
	//�O�d�ŰѼƫغc�l
    public EncoderHandler() {
    }    
	
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		//�]�wrequest���e�^���s�X
		request.setCharacterEncoding("UTF-8"); //�ĥθU�X�s�X
		response.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);//���U��I
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
