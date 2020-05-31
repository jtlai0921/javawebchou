package com.gjun.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gjun.domain.GjunCustomers;
import com.google.gson.Gson;

@WebServlet("/CustomersQryServlet")
public class CustomersQryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//�^��������Ѽ�
		String customerid=request.getParameter("customerid");
		//�A��URL�]�w
		String urlString=String.format("http://localhost:8080/mod15/"
				+ "v1/customers/customersqry/id/%s/rawdata",customerid);
		//�غcURL����
		URL url=new URL(urlString);
		//�}�ҳs��(Request�ݨD)
		HttpURLConnection connection=(HttpURLConnection)url.openConnection();
		//�]�w�ǰe�覡��GET(�t�X��ݪA�ȳ]�w)
		connection.setRequestMethod("GET");
		//���o�^����T��InputStream
		InputStream is=connection.getInputStream();
		//Ū����r��
		InputStreamReader reader=new InputStreamReader(is);
		BufferedReader buffer=new BufferedReader(reader);
		StringBuilder builder=new StringBuilder();
		String line=null;
		while((line=buffer.readLine())!=null) {
			builder.append(line);
		}
		String content=builder.toString();
		//�ϧǦC�ƪ���
		Gson gson=new Gson();
		GjunCustomers customers=gson.fromJson(content, GjunCustomers.class);
		reader.close();
		
		//�^�������T
		PrintWriter out=response.getWriter();
		out.println(String.format("<h1>FristName: %s</h1>",customers.getFirst_name()));
		
		
				
	}
       
    

}
