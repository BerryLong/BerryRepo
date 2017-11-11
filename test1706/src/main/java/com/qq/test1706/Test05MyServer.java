package com.qq.test1706;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  服务器类
 *  BUG 查不到原因  始终不能访问静态的图片  网页无法显示  其余jsp ,html ,pdf ,jpg都能直接访问
 * @author Berry
 */
public class Test05MyServer {

    public static void main(String[] args) throws  IOException {
        Socket socket = null;
            // 创建一个监听9090端口的服务器Socket
            ServerSocket s = new ServerSocket(9090, 3);
            //接收web页面的请求，并开启页面响应服务器
            while (true) {
                socket = s.accept();
                new Test05MyWebServer(socket).start();
            }
    }
}
