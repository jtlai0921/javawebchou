package com.gjun.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class MyBodyTagSupportHandler extends BodyTagSupport {

	//Overriding doAfterBody
	public int doAfterBody() throws JspException 
	{
		try {
			//參考出注入進來的BodyContent物件
			BodyContent bodycontent = getBodyContent();
			//取出Body內容
			String body = bodycontent.getString();
			//取出JspWriter子類別物件
			JspWriter out = bodycontent.getEnclosingWriter();
			//判斷Body已經有設定內容
			if(body != null) {
				//轉換成大寫輸出
				out.print(body.toUpperCase());
			}
		} catch(IOException ioe) {
			throw new JspException("錯誤:"+ioe.getMessage());
		}
		return SKIP_BODY;
	}

}
