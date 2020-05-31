package com.gjun.task;

import java.io.PrintWriter;

import javax.servlet.AsyncContext;
//實作Runnable
public class AsyncRequest implements Runnable {
	  private AsyncContext context;
	  private int ms;
	  private static int number;
	  //自訂建構子 傳遞AsyncContext與佇列區的毫秒
	  public AsyncRequest(AsyncContext context, int ms) {
	    this.context = context;
	    this.ms = ms;
	  }
	  @Override
	  public void run() {
	    try {
	      // 模擬長時間的處理
	      Thread.sleep(ms);  
	      //callback取出回應訊息到前端相對的ServletResponse物件 寫出訊息到前端
	      PrintWriter out = context.getResponse().getWriter();
	      out.println("處理完成 讓您久等了.... " + ++number);
	      // 正式callback處理 回訊息到前端去
	      context.complete(); //正式完成    
	    } catch (Exception e) {
	       e.printStackTrace();
	    }
	  }
	}