/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.concurrency2;

/**
 *
 * @author kerch
 */
public class Main2 {
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("--------Start------------");
        ThreadTree [] array = new ThreadTree[10];
        for (int i = 0; i < array.length; i++) {
            array[i]=new ThreadTree(10, 1000);    
            array[i].start();
        }
        for (int i = 0; i < array.length; i++) {
            array[i].join();
        }
        
        System.out.println("--------end------------");
        
    }
    
}
