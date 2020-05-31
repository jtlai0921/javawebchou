package com.gjun.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import com.gjun.domain.AppUtility;
//聆聽Session Bidning Attribute參照狀態時引發事件
@WebListener()
public class SessionBindingHandler implements HttpSessionAttributeListener
{

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		String name=se.getName();
		
		Object value=se.getValue();
		String msg =String.format("新增Attribute Binding Name:%s 值:%s", name,value);
		//呼叫處理Output method
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
		String msg =String.format("移除Attribute Name:%s 值:%s", name,value);
		//呼叫處理Output method
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
		String msg =String.format("修改Attribute Name:%s 值:%s", name,value);
		//呼叫處理Output method
		try {
			AppUtility.writerSessionAttributeLog("c:/data/session.log",msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
