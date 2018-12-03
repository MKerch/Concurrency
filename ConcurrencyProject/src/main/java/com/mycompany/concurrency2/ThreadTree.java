/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.concurrency2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kerch
 */
public class ThreadTree extends Thread{

    private int n;
    private long delay;

    public ThreadTree(int n, long delay) {
        this.n = n;
        this.delay = delay;
        this.setDaemon(true);
    }
    
    @Override
    public void run() {
        System.out.println("\t Thread started id="+this.getId());
        for(int i=1;i<10;i++){
            System.out.println("\t\t"+ this.getId()+"#"+i);
            try {
                Thread.sleep(delay);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadTree.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        System.out.println("\t Thread finished id="+this.getId());
    }
    
}
