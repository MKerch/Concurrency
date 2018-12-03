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
public class MyConsumer extends Thread{
    
    private BlockingQueue queue;

    public MyConsumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
       while(true){
           try {
           Object poll = queue.take();
           System.out.println("\t Consumed "+poll);
               Thread.sleep(2000);
           } catch (InterruptedException ex) {
               Logger.getLogger(MyConsumer.class.getName()).log(Level.SEVERE, null, ex);
           }
       } 
    }
    
    
}
