package com.gjun.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.Tag;

public class MyBodyTagHandler implements BodyTag {
	private PageContext pageContext;
	private BodyContent bodyContent;
	private String message;
	private int counter=1;
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int doAfterBody() throws JspException {
		//�Ŷq���榸��
		if(counter>3) {
			return EVAL_PAGE;
		}else {
			counter++;
			return EVAL_BODY_AGAIN;
		}
	}

	@Override
	public int doEndTag() throws JspException {
		JspWriter writer=this.pageContext.getOut();
		try {
			writer.print("<h1>��������</h1>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		JspWriter writer=this.pageContext.getOut();
		try {
			writer.print("<h1>�}�l����</h1>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
		
	}

	@Override
	public Tag getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		this.pageContext=pageContext;
		
	}

	@Override
	public void setParent(Tag arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doInitBody() throws JspException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBodyContent(BodyContent bodyContent) {
		this.bodyContent=bodyContent;
		
	}

}
