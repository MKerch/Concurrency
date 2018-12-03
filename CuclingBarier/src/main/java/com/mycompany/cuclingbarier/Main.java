/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cuclingbarier;

import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author kerch
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(1);
        MyThreadA a = new MyThreadA(barrier);
        MyThreadB b = new MyThreadB(barrier);
        a.start();
        b.start();
    }
    
}
