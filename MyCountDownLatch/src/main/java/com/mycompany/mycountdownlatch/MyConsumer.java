/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mycountdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kerch
 */
public class MyConsumer extends Thread {

    private CountDownLatch countDownLatch;

    public MyConsumer(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Consumer start");
        try {
            countDownLatch.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(MyConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Consumer end");

    }

}
