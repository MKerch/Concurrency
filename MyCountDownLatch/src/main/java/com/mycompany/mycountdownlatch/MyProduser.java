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
public class MyProduser extends Thread{

    private CountDownLatch countDownLatch;

    public MyProduser(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            countDownLatch.countDown();
            System.out.println("CountDownLatch "+countDownLatch.getCount());
            try {
                sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyProduser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
}
