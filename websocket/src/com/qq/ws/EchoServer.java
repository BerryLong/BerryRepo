package com.qq.ws;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/ws/echo")
public class EchoServer {

    @OnMessage
    public void echoTextMessage(Session session, String msg) {
        try {
            if (session.isOpen()) {
                session.getBasicRemote().sendText(msg);
            }
        } catch (IOException e) {
            try {
                session.close();
            } catch (IOException e1) {
            }
        }
    }
}
