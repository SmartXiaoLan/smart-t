package cn.smart.socket;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * WenSocket的支持方式
 */
@ServerEndpoint("/myapp.ws")
public class MyWebSocket {
    @OnMessage
    public void message(String message, Session session){
        for(Session s : session.getOpenSessions()){
            s.getAsyncRemote().sendText(message);
        }
    }
}
