package com.gjun.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

//�ۭq����
public class HelloTag implements Tag{
	//attribute
	private Tag parent;
	private PageContext pageContext;

	@Override
	public int doEndTag() throws JspException {
		//�z�LPageContext���XWriter
		JspWriter out=this.pageContext.getOut();
		//�g�X��T
		try {
			out.println("<font size='5' color='blue'>�j�a�n�A�����}�F!!</font>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		//�z�LPageContext���XWriter
		JspWriter out=this.pageContext.getOut();
		//�g�X��T
		try {
			out.println("<font size='5' color='blue'>�j�a�n�A�ڨӤF!!</font><br/>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	@Override
	public Tag getParent() {
		return this.parent;
	}

	@Override
	public void release() {
		
		
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		this.pageContext=pageContext;
		
	}

	@Override
	public void setParent(Tag parent) {
		this.parent=parent;
		
	}

}
