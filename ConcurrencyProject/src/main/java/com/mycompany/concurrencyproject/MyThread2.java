/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.concurrencyproject;

/**
 *
 * @author kerch
 */
public class MyThread2 extends Thread {

    public MyThread2() {
        this.setDaemon(true);
    }

    
    
    @Override
    public void run() {
        Work2 two = new Work2();
        try {
            two.doAction();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

}
