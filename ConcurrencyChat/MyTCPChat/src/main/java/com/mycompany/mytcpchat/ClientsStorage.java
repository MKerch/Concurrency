/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mytcpchat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kerch
 */
public class ClientsStorage {

    private List<ClientThread> list = new ArrayList<>();
    private static ClientsStorage client = new ClientsStorage();

    private ClientsStorage() {
    }

    public synchronized void addClient(ClientThread client) {
        list.add(client);
        //client.start();
    }

    public synchronized void remuveClient(ClientThread client) {
        list.remove(this);
    }

    public void sentToAll(String msg) throws IOException {
        for (ClientThread clientThread : list) {
            clientThread.sentMessage(msg);
        }
    }
    
    public static synchronized ClientsStorage getInstance(){
        return client;
    }

}
