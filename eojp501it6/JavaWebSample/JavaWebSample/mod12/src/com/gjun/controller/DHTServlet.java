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
		//�^��QueryString�[�c�ǻ��i�Ӫ��ŷë׸��
		String temper=request.getParameter("temper");
		String humi=request.getParameter("humi");
		//�غcDHT����
		DHTEntity dht=new DHTEntity();
		dht.setTemper(Double.parseDouble(temper));
		dht.setHumi(Double.parseDouble(humi));
		//�ǦC�Ʀ�JSON String
		Gson gson=new Gson();
		String dhtString=gson.toJson(dht);
		//�غcSensorData����
		SensorData data=new SensorData();
		data.setId("DHT11_1");
		data.setLan(121.517066);
		data.setLat(25.053523);
		data.setSave(true);
		//�t�ήɶ��ഫ��ISO8601
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		// �ഫISO8601
		SimpleDateFormat sdf;
		sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT") );
		String text = sdf.format(date);
		data.setTime(text);
		//�غc���X����
		List<String> value=new ArrayList<>();
		value.add(dhtString);
		data.setValue(value);
		//�غc���X����
		List<SensorData> json=new ArrayList<>();
		json.add(data);
		//�ǦC�Ʀ�JSON
		String dataString=gson.toJson(json);
		//Http Client���X�ШD
		URL url=new URL("https://iot.cht.com.tw/iot/v1/device/20627236882/rawdata");
		HttpURLConnection connection=(HttpURLConnection)url.openConnection();
		//�]�w�ǰe�覡
		connection.setRequestMethod("POST");
		//�]�wHeader
		connection.setRequestProperty("Content-Type","application/json");
		connection.setRequestProperty("CK","PK7SXHGXG53WME1RXX");
		connection.setDoInput(true);
	    connection.setDoOutput(true);
		
		//�g�X���
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
