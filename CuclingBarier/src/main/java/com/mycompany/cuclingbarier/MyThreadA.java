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
public class MyThreadA extends Thread {

    private CyclicBarrier barrier;

    public MyThreadA(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println("Thread A started");
        try {
            sleep(2000);
            System.out.println("Thread A after delay");
            barrier.await();
            System.out.println("Thread A finish");
        } catch (Exception ex) {
            Logger.getLogger(MyThreadA.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
