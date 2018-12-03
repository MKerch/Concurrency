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
public class MyProducer extends Thread {

    private String resourceA;
    private String resourceB;

    public MyProducer(String resourceA, String resourceB) {
        this.resourceA = resourceA;
        this.resourceB = resourceB;
    }

    @Override
    public void run() {
        System.out.println("MyProducer start");
        synchronized (resourceA) {
            System.out.println("MyProducer inside " + resourceA);
            try {
                Thread.sleep(2000);
                synchronized (resourceB) {
                    System.out.println("MyProducer inside " + resourceB);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(MyProducer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
