package com.gjun.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MySimpleTagHandler extends SimpleTagSupport {
	//Attribute屬性
	private String url = "";
	private boolean showBorder = false;
	private boolean showUrl = false;
	//設定圖片來源
	public void setUrl(String url) {
		this.url = url;
	}
	//呈現邊線效果
	public void setShowBorder(boolean showBorder) {
		this.showBorder = showBorder;
	}
	//呈現圖片位址
	public void setShowUrl(boolean showUrl) {
		this.showUrl = showUrl;
	}
	//Overriding doTag
	public void doTag() throws JspException {

		PageContext pageContext = (PageContext) getJspContext();
		JspWriter out = pageContext.getOut();

		try {
			StringBuffer sb = new StringBuffer();
			if (showUrl) {
				sb.append("<h3>");
				sb.append(url);
				sb.append("</h3>\n");
			}
			sb.append("<img width='200px' height='200px' ");
			if (showBorder) {
				sb.append("border=\"1\" ");
			}
			sb.append("alt=\"\" src=\"");
			sb.append(url);
			sb.append("\"/>");

			out.println(sb.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}