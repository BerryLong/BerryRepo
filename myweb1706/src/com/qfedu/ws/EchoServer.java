package com.qfedu.ws;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

// ws://localhost:8080/ws/echo
// var ws = new WebSocket("ws://localhost:8080/ws/echo");
// ws.onmessage = function(evt) { evt.data; };
// ws.send('...');
@ServerEndpoint("/ws/echo")
public class EchoServer {

    @OnMessage
    public void sendEchoMessage(Session session, String message) {
        if (session.isOpen()) {
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
