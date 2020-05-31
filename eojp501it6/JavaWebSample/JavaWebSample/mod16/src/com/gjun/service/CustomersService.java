
package com.gjun.service;

import com.gjun.entity.Customers;
import com.google.gson.Gson;
import javax.websocket.OnMessage;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/mycustomers/{cid}/rawdata")
public class CustomersService {
    
    @OnMessage
    public String getCustomers(@PathParam("cid")String customerid,String message)
    {
        
        Customers customers=new Customers();
        customers.setId(customerid);
        customers.setName(message);
        customers.setAddress("еxе_ел");
     
        Gson gson=new Gson();
       
        return gson.toJson(customers);
      
    }
}
