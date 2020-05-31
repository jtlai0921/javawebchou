package com.gjun.view;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gjun.task.AsyncRequest;

@WebServlet(name = "AsyncServlet",urlPatterns = {"/async.view"},
asyncSupported = true)

public class AsyncServlet extends HttpServlet {
  // �������(�T�w�ƶq�������Pooling)
   private ExecutorService executorService = Executors.newFixedThreadPool(10);
  //Overriding doGet 
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	//�]�w�^���s�X
    response.setContentType("text/html; charset=UTF8");
    //���X�ǻ��i�Ӫ�Queue�ѼƤ����@���
    int ms = Integer.parseInt(request.getParameter("ms"));
    //�z�LServletRequest�����D�P�B�B�̪�AsyncContext����
    AsyncContext ctx = request.startAsync();
    //�ǻ�AsyncContext�P���d��� �`�J�@��AsyncRequest����(Runnable)
    executorService.submit(new AsyncRequest(ctx, ms));
        
  }

  @Override
  public void destroy() {
    executorService.shutdown(); //����Thread Pooling
  }
}