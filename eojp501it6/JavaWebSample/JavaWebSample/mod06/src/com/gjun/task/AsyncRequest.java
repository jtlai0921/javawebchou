package com.gjun.task;

import java.io.PrintWriter;

import javax.servlet.AsyncContext;
//��@Runnable
public class AsyncRequest implements Runnable {
	  private AsyncContext context;
	  private int ms;
	  private static int number;
	  //�ۭq�غc�l �ǻ�AsyncContext�P��C�Ϫ��@��
	  public AsyncRequest(AsyncContext context, int ms) {
	    this.context = context;
	    this.ms = ms;
	  }
	  @Override
	  public void run() {
	    try {
	      // �������ɶ����B�z
	      Thread.sleep(ms);  
	      //callback���X�^���T����e�ݬ۹諸ServletResponse���� �g�X�T����e��
	      PrintWriter out = context.getResponse().getWriter();
	      out.println("�B�z���� ���z�[���F.... " + ++number);
	      // ����callback�B�z �^�T����e�ݥh
	      context.complete(); //��������    
	    } catch (Exception e) {
	       e.printStackTrace();
	    }
	  }
	}