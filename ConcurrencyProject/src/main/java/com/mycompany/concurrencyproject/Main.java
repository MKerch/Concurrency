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
public class Main {
    
    
    public static void main(String[] args) throws InterruptedException {
        
//        Work1 one = new Work1();
//        Work2 two = new Work2();
//        
//        one.doAction();
//        two.doAction();
        
        MyThread1 thread1 = new MyThread1();
        MyThread2 thread2 = new MyThread2();
        
        thread1.start();
        thread2.start(); 
        //thread2.start();
        System.out.println("main finish");
    }
    
}
