package com.gjun.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.gjun.domain.AppUtility;
@WebListener()
public class SessionHandler implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		String sessionId=se.getSession().getId();
		String msg=String.format("Session ID:%s �إ߰_��!!\n",sessionId);
		try {
			AppUtility.writerSessionAttributeLog("c:/data/session.txt",msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		String sessionId=se.getSession().getId();
		String msg=String.format("Session ID:%s �Q����!!\n",sessionId);
		try {
			AppUtility.writerSessionAttributeLog("c:/data/session.txt",msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
