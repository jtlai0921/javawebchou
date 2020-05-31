package com.gjun.service;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
//���۩I�A��
@Path("hello")
public class HelloService {
	//�ϥ�Annotation�t�m�A�ȯS�x
	@Path("helloworld")
	@GET
	@Produces("text/plain")
	public String helloWorld()
	{
		return "Hello World";
	}
	
	//�ĥ�QueryString�覡�ǻ��Ѽƭ�
	@Path("hihello")
	@GET
	@Produces("text/plain")
	public String helloWorld(@QueryParam("w")String who) {
		return String.format("%s �z�n",who);
	}
	
	
	//�ĥ�QueryString�覡�ǻ��Ѽƭ�
	@Path("gjunhello/{msg}/rawdata")
	@GET
	@Produces("text/plain")
	public String gjunWorld(@PathParam("msg")String message) {
		return String.format("%s �z�n",message);
	}
	
	
	

}
