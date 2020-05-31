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
  // 執行緒池(固定數量的執行緒Pooling)
   private ExecutorService executorService = Executors.newFixedThreadPool(10);
  //Overriding doGet 
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	//設定回應編碼
    response.setContentType("text/html; charset=UTF8");
    //取出傳遞進來的Queue參數中的毫秒數
    int ms = Integer.parseInt(request.getParameter("ms"));
    //透過ServletRequest取的非同步處裡的AsyncContext物件
    AsyncContext ctx = request.startAsync();
    //傳遞AsyncContext與停留秒數 注入一個AsyncRequest物件(Runnable)
    executorService.submit(new AsyncRequest(ctx, ms));
        
  }

  @Override
  public void destroy() {
    executorService.shutdown(); //停止Thread Pooling
  }
}