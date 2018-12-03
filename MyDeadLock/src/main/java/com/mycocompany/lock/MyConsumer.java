/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycocompany.lock;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kerch
 */
public class MyConsumer extends Thread {

    private String resourceA;
    private String resourceB;

    public MyConsumer(String resourceA, String resourceB) {
        this.resourceA = resourceA;
        this.resourceB = resourceB;
    }

    @Override
    public void run() {
        System.out.println("MyConsumer start");
        synchronized (resourceB) {
            try {
                System.out.println("Consumer inside " + resourceB);
                Thread.sleep(1000);
                synchronized (resourceA) {
                    System.out.println("Consumer inside " + resourceA);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(MyConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
