/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mytcpchat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kerch
 */
public class ClientThread extends Thread {

    private Socket socket;
    private String name;
    private InputStream inputStream;
    private OutputStream outputStream;

    public ClientThread(Socket socket, String name) {
        try {
            this.socket = socket;
            this.name = name;
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                //System.out.println(inputStream.available());
                if (inputStream.available() > 0) {
                    //System.out.println("inside if");
                    /*int i = -1;
                    while ((i = inputStream.read()) !=-1) {
                        out.write(i);
                    }*/
                    byte[] bytes = new byte[inputStream.available()];
                    inputStream.read(bytes);
                    
                    //byte[] bytes = out.toByteArray();
                    String data = new String(bytes);
                    //if (bytes.length != 0) {
                    System.out.println("Client sent " + data);
                    ClientsStorage clientsStorage = ClientsStorage.getInstance();
                    clientsStorage.sentToAll(data);
                    //}
                }
                Thread.sleep(500);
            } catch (Exception ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void sentMessage(String msg) throws IOException {
      //  OutputStream outputStream = socket.getOutputStream();
        outputStream.write(msg.getBytes());
    }
}
