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
public class MyProducer extends Thread {

    private int value;
    private boolean produced;
    private MyConsumer consumer;

    public void setConsumer(MyConsumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void run() {
        System.out.println("\tProducer-RUN!!!!");
        int i=0;
        while (true) {
           
            System.out.println("\t\tProducer-iteration #"+i++);
            //synchronized (this) {
                System.out.println("\t\t\tProducer-Iinside synchronized (this). iteration #"+i+";"+"produced= "+produced);
                int j=0;
                while (produced) {
                    System.out.println("\t\t\t\tProducer-Iinside while (produced). iteration #"+j++);
                    try {
                        System.out.println("\t\t\t\t\tProducer @before wait");
                        synchronized (this) {
                          this.wait();
                        }
                        System.out.println("\t\t\t\t\tProducer @after wait");
                    } catch (Exception ex) {
                        Logger.getLogger(MyProducer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("\t\t\t\tProducer-Exit  while (produced). iteration #"+j);
                value++;
                System.out.println("Produced " + value);
                produced = true;
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MyProducer.class.getName()).log(Level.SEVERE, null, ex);
                }
            //}
            System.out.println("\t\t\tProducer-Exit synchronized (this). iteration #"+i);
                    

            synchronized (consumer) {
                System.out.println("\t\t\tProducer-Inside synchronized (consumer). iteration #"+i);
                consumer.notify();
                System.out.println("\t\t\tProducer-After notify(). iteration #"+i);
            }

        }
    }

    public boolean isProduced() {
        return produced;
    }

    public int consumeValue() {
        produced = false;
        return value;
    }

}
