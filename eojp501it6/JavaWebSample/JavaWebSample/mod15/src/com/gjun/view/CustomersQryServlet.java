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
		//擷取表單欄位參數
		String customerid=request.getParameter("customerid");
		//服務URL設定
		String urlString=String.format("http://localhost:8080/mod15/"
				+ "v1/customers/customersqry/id/%s/rawdata",customerid);
		//建構URL物件
		URL url=new URL(urlString);
		//開啟連接(Request需求)
		HttpURLConnection connection=(HttpURLConnection)url.openConnection();
		//設定傳送方式為GET(配合後端服務設定)
		connection.setRequestMethod("GET");
		//取得回應資訊的InputStream
		InputStream is=connection.getInputStream();
		//讀取文字串
		InputStreamReader reader=new InputStreamReader(is);
		BufferedReader buffer=new BufferedReader(reader);
		StringBuilder builder=new StringBuilder();
		String line=null;
		while((line=buffer.readLine())!=null) {
			builder.append(line);
		}
		String content=builder.toString();
		//反序列化物件
		Gson gson=new Gson();
		GjunCustomers customers=gson.fromJson(content, GjunCustomers.class);
		reader.close();
		
		//回應物件資訊
		PrintWriter out=response.getWriter();
		out.println(String.format("<h1>FristName: %s</h1>",customers.getFirst_name()));
		
		
				
	}
       
    

}
