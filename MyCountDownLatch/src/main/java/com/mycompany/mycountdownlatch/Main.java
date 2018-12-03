/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mycountdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @author kerch
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        CountDownLatch countDownLatch = new CountDownLatch(5);
        MyProduser myProduser = new MyProduser(countDownLatch);
        MyConsumer consumer = new MyConsumer(countDownLatch);
        
        myProduser.start();
        consumer.start();
        
    }
    
}
