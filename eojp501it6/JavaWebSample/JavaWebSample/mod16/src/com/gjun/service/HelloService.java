
package com.gjun.service;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/gjun")
public class HelloService {
    
    @OnMessage
    public String helloWorld(String clientRequestMessage)
    {
        return String.format("%s Hello World!! �@�ɩM��!!",clientRequestMessage);
    }
    
}
