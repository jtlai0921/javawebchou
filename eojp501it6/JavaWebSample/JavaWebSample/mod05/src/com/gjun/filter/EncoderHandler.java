package com.gjun.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


//實作Filter介面
public class EncoderHandler implements Filter {
   
	//保留空參數建構子
    public EncoderHandler() {
    }    
	
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		//設定request內容擷取編碼
		request.setCharacterEncoding("UTF-8"); //採用萬碼編碼
		response.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);//往下交付
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
