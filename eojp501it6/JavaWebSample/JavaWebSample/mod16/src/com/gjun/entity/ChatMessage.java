
package com.gjun.entity;

//JavaBean²á¤Ñ°T®§
public class ChatMessage implements java.io.Serializable {
    private String id;
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
