/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eventapp;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kerch
 */
public class MyConsumer extends Thread {

    private MyProducer producer;

    public MyConsumer(MyProducer producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                while (!producer.isProduced()) {
                    try {
                        this.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MyConsumer.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
            synchronized(producer){
                try {
                    System.out.println("{consumer is in sleep}");
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MyConsumer.class.getName()).log(Level.SEVERE, null, ex);
                }
                int res = producer.consumeValue();
                System.out.println("\t Consumed "+res);
                producer.notify();
            }

        }

    }

}
