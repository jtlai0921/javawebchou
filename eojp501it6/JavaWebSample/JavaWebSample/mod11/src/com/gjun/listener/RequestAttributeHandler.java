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
//�G�pListener
@WebListener()
public class RequestAttributeHandler implements ServletRequestAttributeListener {
	

	//��ť�s�WAttribute
	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		//�}��Log File
		try {
			File file=new File("c:/data/log.txt");
			if(!file.exists())
			{
				return;
			}
			OutputStream os=new FileOutputStream(file,true);
			OutputStreamWriter writer=new OutputStreamWriter(os,"UTF-8");
			
			//�g�X��T
			writer.write(String.format("request�޲z������:%s\n",
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
