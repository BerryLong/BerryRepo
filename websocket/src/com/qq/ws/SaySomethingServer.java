package com.qq.ws;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@ServerEndpoint("/ws/say")
public class SaySomethingServer {

    private static List<String> sentencesList = new CopyOnWriteArrayList<>(Arrays.asList(
            "世上并没有绝望的处境，只有对处境绝望的人",
            "人生的道路在态度的岔口一分为二，从此通向成功或失败",
            "不思进取也是对生命的不负责任",
            "生命的精彩之处在于有太多的不确定性",
            "只有非常的努力，才能看起来毫不费力"
    ));
    private List<Session> wsClients = new CopyOnWriteArrayList<>();
    private boolean started = false;

    @OnOpen
    public void start(Session session){
        wsClients.add(session);
        if(!started){
            new Thread(()->{
                while (true){
                    delay((long) (Math.random() * 5001 + 3000));
                    int index = (int) (Math.random() * (sentencesList.size() - 1));
                    String sentence = sentencesList.remove(index);

                    for(Session tempSession:wsClients){
                        try {
                            if(tempSession.isOpen()){
                            tempSession.getBasicRemote().sendText(sentence);
                            } else{
                                wsClients.remove(tempSession);
                            }
                        } catch (IOException e) {
//                            e.printStackTrace();
                        }
                        sentencesList.add(sentence);
                    }
                }
            }).start();

            started = true;
        }
    }
    private void delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
