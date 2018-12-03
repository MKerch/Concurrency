/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.blokingqueueexamples;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kerch
 */
public class MyProducer extends Thread {

    private BlockingQueue queue;
    private int value;

    public MyProducer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                value++;
                System.out.println("Produced " + value);
                queue.put(value);
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyProducer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
