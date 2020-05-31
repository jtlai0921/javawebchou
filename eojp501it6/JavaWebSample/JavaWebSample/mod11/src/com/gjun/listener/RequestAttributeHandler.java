package com.gjun.listener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
//佈署Listener
@WebListener()
public class RequestAttributeHandler implements ServletRequestAttributeListener {
	

	//聆聽新增Attribute
	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		//開啟Log File
		try {
			File file=new File("c:/data/log.txt");
			if(!file.exists())
			{
				return;
			}
			OutputStream os=new FileOutputStream(file,true);
			OutputStreamWriter writer=new OutputStreamWriter(os,"UTF-8");
			
			//寫出資訊
			writer.write(String.format("request管理的物件:%s\n",
					srae.getValue().toString()));
			
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			
			
		} catch (UnsupportedEncodingException e) {
			
		} catch (IOException e) {
			
		}
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		
	}

	
	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		
	}

}
