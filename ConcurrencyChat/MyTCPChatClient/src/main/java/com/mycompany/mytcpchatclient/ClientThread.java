/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mytcpchatclient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author kerch
 */
public class ClientThread extends Thread {

    private Socket socket;
    private String name;
    private JTextArea area;
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

    public void setArea(JTextArea area) {
        this.area = area;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if(inputStream.available()>0){
                    
                byte[] bytes = new byte[inputStream.available()];
                inputStream.read(bytes);
                String data = new String(bytes);
                //if (bytes.length != 0) {
                    area.append(data);
                //}
                }
            } catch (IOException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void sentMessage(String msg) throws IOException {
//        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(msg.getBytes());
        System.out.println("After write");
    }
}
