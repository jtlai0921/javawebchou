package com.gjun.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gjun.domain.DHTEntity;
import com.gjun.domain.SensorData;
import com.google.gson.Gson;


@WebServlet("/DHTServlet")
public class DHTServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//擷取QueryString架構傳遞進來的溫溼度資料
		String temper=request.getParameter("temper");
		String humi=request.getParameter("humi");
		//建構DHT物件
		DHTEntity dht=new DHTEntity();
		dht.setTemper(Double.parseDouble(temper));
		dht.setHumi(Double.parseDouble(humi));
		//序列化成JSON String
		Gson gson=new Gson();
		String dhtString=gson.toJson(dht);
		//建構SensorData物件
		SensorData data=new SensorData();
		data.setId("DHT11_1");
		data.setLan(121.517066);
		data.setLat(25.053523);
		data.setSave(true);
		//系統時間轉換成ISO8601
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		// 轉換ISO8601
		SimpleDateFormat sdf;
		sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT") );
		String text = sdf.format(date);
		data.setTime(text);
		//建構集合物件
		List<String> value=new ArrayList<>();
		value.add(dhtString);
		data.setValue(value);
		//建構集合物件
		List<SensorData> json=new ArrayList<>();
		json.add(data);
		//序列化成JSON
		String dataString=gson.toJson(json);
		//Http Client提出請求
		URL url=new URL("https://iot.cht.com.tw/iot/v1/device/20627236882/rawdata");
		HttpURLConnection connection=(HttpURLConnection)url.openConnection();
		//設定傳送方式
		connection.setRequestMethod("POST");
		//設定Header
		connection.setRequestProperty("Content-Type","application/json");
		connection.setRequestProperty("CK","PK7SXHGXG53WME1RXX");
		connection.setDoInput(true);
	    connection.setDoOutput(true);
		
		//寫出資料
		DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
        outputStream.write(dataString.toString().getBytes("UTF-8"));
        outputStream.flush();
        outputStream.close();

        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        BufferedReader br = new BufferedReader(reader);
        String line = null;
        StringBuilder builder=new StringBuilder();
        while( (line = br.readLine()) != null ) {
            builder.append(line+"\n");
        }
        outputStream.close();
        response.getWriter().println(builder.toString());
		
		
		
	}

}
