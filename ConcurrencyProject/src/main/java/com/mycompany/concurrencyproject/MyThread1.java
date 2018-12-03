/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.concurrencyproject;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kerch
 */
public class MyThread1 extends Thread {

    public MyThread1() {
        this.setDaemon(true);
        this.setPriority(1);
        
    }

    @Override
    public void run() {
        Work1 one = new Work1();
        try {
            one.doAction();
        } catch (Exception ex) {
        throw new RuntimeException(ex);
        }
    }
    
}
