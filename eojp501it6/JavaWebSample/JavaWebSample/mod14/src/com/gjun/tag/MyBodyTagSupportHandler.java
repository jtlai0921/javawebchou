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
			//�ѦҥX�`�J�i�Ӫ�BodyContent����
			BodyContent bodycontent = getBodyContent();
			//���XBody���e
			String body = bodycontent.getString();
			//���XJspWriter�l���O����
			JspWriter out = bodycontent.getEnclosingWriter();
			//�P�_Body�w�g���]�w���e
			if(body != null) {
				//�ഫ���j�g��X
				out.print(body.toUpperCase());
			}
		} catch(IOException ioe) {
			throw new JspException("���~:"+ioe.getMessage());
		}
		return SKIP_BODY;
	}

}
