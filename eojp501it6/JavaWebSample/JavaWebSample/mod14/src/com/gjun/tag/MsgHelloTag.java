package com.gjun.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class MsgHelloTag extends TagSupport{
	//attributte
	private String message;
	//<xxx>body</xxx> body執行之後
	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		return super.doAfterBody();
	}

	//<xxx></xxx>結束標籤執行之後
	@Override
	public int doEndTag() throws JspException {
		//參考出PageContext物件
		PageContext pageContext=this.pageContext;
		//取出Writer
		JspWriter out=pageContext.getOut();
		String msg=String.format("<font size='6' color='red'>%s 您好!!</font>",message);
		try {
			out.println(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE; //回應旗標 繼續往下執行
	}

	//getter and setter
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
