/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mytcpchat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author kerch
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(9898);
        ClientsStorage clientsStorage = ClientsStorage.getInstance();
        int i =0;
        System.out.println("##########____SERVER STERTED___#########");
        while (true) {
            Socket clientSocket = server.accept();
            ClientThread clientThread = new ClientThread(clientSocket, "name " + i++);
            clientThread.start();
            clientsStorage.addClient(clientThread);
            System.out.println("New client created");
            
            
        }
    }

}
