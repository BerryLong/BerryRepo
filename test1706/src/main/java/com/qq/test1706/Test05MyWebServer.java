package com.qq.test1706;

import java.io.*;
import java.net.Socket;
import java.net.URLDecoder;

/**
 * 页面响应服务器
 * @author Berry
 */
public class Test05MyWebServer extends Thread {
    private Socket socket;
    private String resource;
    Test05MyWebServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            PrintStream out;
            out = new PrintStream(socket.getOutputStream());
            if (socket != null){
                try {
                    BufferedReader reader
                            = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    //请求行
                    String line = reader.readLine();

                    System.out.println("line: " + line);

                    //请求行获取请求后缀名
                    resource = line.substring(line.indexOf('/') +1,
                            line.lastIndexOf('/') - 5);

                    System.out.println("the resource you request is: "
                            + resource);

                    resource = URLDecoder.decode(resource, "UTF-8");

                    if(resource.endsWith(".jpg")){
                        transferFileHandle(System.getProperty("user.dir")+"/test1706/src/main/webapp/img/"+resource, socket);
                        socket.close();
                    } else if(resource.endsWith(".pdf")){
                        transferFileHandle(System.getProperty("user.dir")+"/test1706/src/main/webapp/file/"+resource,socket);
                        socket.close();
                    }else if(resource.endsWith(".html")){
                        transferFileHandle(System.getProperty("user.dir")+"/test1706/src/main/webapp/html/"+resource, socket);
                        socket.close();
                    }else if(resource.endsWith(".jsp")){
                        transferFileHandle(System.getProperty("user.dir")+"/test1706/src/main/webapp/jsp/"+resource, socket);
                        socket.close();
                    } else{
                        out.println("HTTP/1.1 200 OK");
                        out.println("Content-Type:text/html;charset:utf-8");
                        out.println();
                        out.println("<html><body>"
                                + "<h1>Hello,Server!</h1>"
                                + "</body></html>");
                        out.flush();
                        out.close();
                        socket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *  服务器响应页面的内容
     */
    private void transferFileHandle(String path, Socket socket) {

        File file = new File(path);

        if (file.exists() && !file.isDirectory()) {
            try {
                OutputStream out = socket.getOutputStream();
                //拼接请求行
                String s="HTTP/1.0 200 OK\r\n";
                if(resource.endsWith(".jpg")) {
                    s=s+"Content-Type:image/jpeg\r\n";
                }else if(resource.endsWith(".pdf")) {
                    s=s+"Content-Type:application/pdf\r\n";
                }else{
                    s=s+"Content-Type:text/html\r\n";
                }
                s=s+"Content-Length:" + file.length()+"\r\n";
                s=s+"\r\n";// 根据 HTTP 协议, 空行将结束头信息
                out.write(s.getBytes());

                FileInputStream fis = new FileInputStream(file);
                byte[] buf = new byte[1024];
                int len=0;
                while((len=fis.read(buf))!=-1) {
                    out.write(buf,0,len);
                }

                out.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
