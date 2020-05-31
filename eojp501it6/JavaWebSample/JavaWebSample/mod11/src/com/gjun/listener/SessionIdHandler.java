package com.gjun.listener;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;

import com.gjun.domain.AppUtility;
@WebServlet
public class SessionIdHandler implements HttpSessionIdListener{

	@Override
	public void sessionIdChanged(HttpSessionEvent event, String oldId) {
		
		String msg=String.format("Session ID被改變了:%s 原先的Id:%s",event.getSession().getId(),oldId);
		try {
			AppUtility.writerSessionAttributeLog("c:/data/id.txt",msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
