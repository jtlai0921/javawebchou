package com.gjun.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

//自訂標籤
public class HelloTag implements Tag{
	//attribute
	private Tag parent;
	private PageContext pageContext;

	@Override
	public int doEndTag() throws JspException {
		//透過PageContext取出Writer
		JspWriter out=this.pageContext.getOut();
		//寫出資訊
		try {
			out.println("<font size='5' color='blue'>大家好，我離開了!!</font>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		//透過PageContext取出Writer
		JspWriter out=this.pageContext.getOut();
		//寫出資訊
		try {
			out.println("<font size='5' color='blue'>大家好，我來了!!</font><br/>");
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
