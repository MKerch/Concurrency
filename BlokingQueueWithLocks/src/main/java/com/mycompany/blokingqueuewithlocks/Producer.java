/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.blokingqueuewithlocks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kerch
 */
public class Producer extends Thread {

    private Lock lock;
    private Condition condition;
    private int value;
    private boolean produced;

    public Producer(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        while (true) {
            boolean tryLock = lock.tryLock();
            if (tryLock) {
                while (produced) {
                    try {
                        condition.await();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                value++;
                produced = true;
                System.out.println("Produced " + value);
                condition.signal();
                lock.unlock();
            }
        }
    }
    
    public boolean isProduced(){
        return produced;
    }

    public int getValue(){
        produced=false;
        return value;
    }
}
