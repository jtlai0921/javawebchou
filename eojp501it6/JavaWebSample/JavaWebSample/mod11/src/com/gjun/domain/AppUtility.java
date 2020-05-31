package com.gjun.domain;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class AppUtility {
	public static void writerSessionAttributeLog(String fileName,String message) throws Exception {
		try {
			//�إߦ�y �}���ɮ�
			OutputStream os=new FileOutputStream(fileName,true);
			//�غcWiter
			OutputStreamWriter writer=new OutputStreamWriter(os,"UTF-8");
			writer.write(message+"\n");
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			throw e;
		} catch (UnsupportedEncodingException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
		
	}

}
