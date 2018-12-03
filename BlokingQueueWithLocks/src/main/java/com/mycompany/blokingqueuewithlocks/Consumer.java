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
public class Consumer extends Thread {

    private Condition condition;
    private Lock lock;
    private Producer producer;

    public Consumer(Condition condition, Lock lock, Producer producer) {
        this.condition = condition;
        this.lock = lock;
        this.producer = producer;
    }

    @Override
    public void run() {
        while (true) {
            boolean tryLock = lock.tryLock();
            if(tryLock){
                while(!producer.isProduced()){
                    try {
                        condition.await();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int value = producer.getValue();
                
                System.out.println("\t Consumed "+value);
                condition.signal();
                lock.unlock();
                try {
                    sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
