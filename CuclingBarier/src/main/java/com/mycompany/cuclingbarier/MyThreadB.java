/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cuclingbarier;

import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kerch
 */
public class MyThreadB extends Thread {

    private CyclicBarrier barrier;

    public MyThreadB(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println("Thread B started");
        try {
            sleep(10000);
            System.out.println("Thread B after delay");
            barrier.await();
            System.out.println("Thread B finished");
        } catch (Exception ex) {
            Logger.getLogger(MyThreadB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
