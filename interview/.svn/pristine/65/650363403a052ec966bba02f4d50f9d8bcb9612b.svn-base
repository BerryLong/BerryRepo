package com.qfedu;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ClientHandler implements  Runnable {
    private Socket client;

    public ClientHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try (InputStream in = client.getInputStream();
                OutputStream out = client.getOutputStream()) {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String requestLine = br.readLine();
            String resourceName = requestLine.split("\\s")[1].substring(1);
            String suffix = getSuffix(resourceName);
            String mimeType = "text/html";
            if (suffix != null) {
                switch (suffix) {
                    case "jpg":
                        mimeType = "image/jpeg";
                        break;
                    case "png":
                        mimeType = "image/png";
                        break;
                    case "pdf":
                        mimeType = "application/pdf";
                        break;
                }
            }
            InputStream resourceIn = getClass().getClassLoader().getResourceAsStream(resourceName);
            byte[] buffer = new byte[resourceIn.available()];
            resourceIn.read(buffer);
            out.write("HTTP/1.1 200 OK\r\n".getBytes());
            out.write(("Content-Length: " + buffer.length + "\r\n").getBytes());
            out.write(("Content-Type: " + mimeType + "\r\n").getBytes());
            out.write("\r\n".getBytes());
            out.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getSuffix(String filename) {
        int pos = filename.lastIndexOf(".");
        if (pos < filename.length() - 1 && pos > 0) {
            return filename.substring(pos + 1);
        }
        return null;
    }
}

public class Exam5 {

    private static ExecutorService service = Executors.newFixedThreadPool(50);
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(80)) {
            while (true) {
                Socket client = server.accept();
                System.out.println(client.getInetAddress().toString() + "连接到服务器.");
                service.execute(new ClientHandler(client));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
    }
}
