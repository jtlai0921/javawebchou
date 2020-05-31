package com.gjun.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class MsgHelloTag extends TagSupport{
	//attributte
	private String message;
	//<xxx>body</xxx> body���椧��
	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		return super.doAfterBody();
	}

	//<xxx></xxx>�������Ұ��椧��
	@Override
	public int doEndTag() throws JspException {
		//�ѦҥXPageContext����
		PageContext pageContext=this.pageContext;
		//���XWriter
		JspWriter out=pageContext.getOut();
		String msg=String.format("<font size='6' color='red'>%s �z�n!!</font>",message);
		try {
			out.println(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE; //�^���X�� �~�򩹤U����
	}

	//getter and setter
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
