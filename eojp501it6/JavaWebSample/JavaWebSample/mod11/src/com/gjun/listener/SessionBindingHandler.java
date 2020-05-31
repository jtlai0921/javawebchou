package com.gjun.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import com.gjun.domain.AppUtility;
//��ťSession Bidning Attribute�ѷӪ��A�ɤ޵o�ƥ�
@WebListener()
public class SessionBindingHandler implements HttpSessionAttributeListener
{

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		String name=se.getName();
		
		Object value=se.getValue();
		String msg =String.format("�s�WAttribute Binding Name:%s ��:%s", name,value);
		//�I�s�B�zOutput method
		try {
			AppUtility.writerSessionAttributeLog("c:/data/sessionbind.log",msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		String name=se.getName();
		Object value=se.getValue();
		String msg =String.format("����Attribute Name:%s ��:%s", name,value);
		//�I�s�B�zOutput method
		try {
			AppUtility.writerSessionAttributeLog("c:/data/session.log",msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		String name=se.getName();
		Object value=se.getValue();
		String msg =String.format("�ק�Attribute Name:%s ��:%s", name,value);
		//�I�s�B�zOutput method
		try {
			AppUtility.writerSessionAttributeLog("c:/data/session.log",msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
