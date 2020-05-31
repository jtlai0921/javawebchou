package com.gjun.service;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
//打招呼服務
@Path("hello")
public class HelloService {
	//使用Annotation配置服務特徵
	@Path("helloworld")
	@GET
	@Produces("text/plain")
	public String helloWorld()
	{
		return "Hello World";
	}
	
	//採用QueryString方式傳遞參數值
	@Path("hihello")
	@GET
	@Produces("text/plain")
	public String helloWorld(@QueryParam("w")String who) {
		return String.format("%s 您好",who);
	}
	
	
	//採用QueryString方式傳遞參數值
	@Path("gjunhello/{msg}/rawdata")
	@GET
	@Produces("text/plain")
	public String gjunWorld(@PathParam("msg")String message) {
		return String.format("%s 您好",message);
	}
	
	
	

}
