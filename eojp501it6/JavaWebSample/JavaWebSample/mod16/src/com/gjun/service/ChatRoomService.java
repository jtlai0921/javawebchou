
package com.gjun.service;

import com.gjun.entity.ChatMessage;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/room/{id}/rawdata")
public class ChatRoomService {
   
	//使用static共用的集合物件 收集名稱對應一個WebSocket Session
	//收集前端Open建立起的Session
    private static Map<String,Session> clients=new HashMap<String,Session>();;
    public ChatRoomService(){
       
    }
    
    //聆聽使用端建立起WebSocket連接
    @OnOpen
    public void connected(@PathParam("id")String id,Session session){
        clients.put(id,session); //收集Session
     
        System.out.println(clients.size());
    }
    
   
    @OnClose
    public void connectionClose(@PathParam("id")String id,Session session){
        clients.remove(id, session);
        System.out.println("前端:"+clients.size());
    }
    
   
    @OnMessage
    public void messageReceived(@PathParam("id")String id,String jsonMessage,Session session){
    	//建構Gson序列化與反序列Json物件
        Gson gson=new Gson();
        //反序列化前端傳遞進來的Json字串
        ChatMessage message=gson.fromJson(jsonMessage, ChatMessage.class);
        //取出聊天對象識別碼
        String who=message.getId();
        //走訪集合中相對的識別碼
        for(String key:clients.keySet()){
            if(key.equals(who))
            {
           
            	//取出應對前端的Session
                Session curSession=clients.get(key);
                try {
                	//透過Session送出聊天文字串到前端
                    curSession.getBasicRemote().sendText(id+"#"+message.getMessage());
                } catch (IOException ex) {
                    Logger.getLogger(ChatRoomService.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    
    }

    
    
}
