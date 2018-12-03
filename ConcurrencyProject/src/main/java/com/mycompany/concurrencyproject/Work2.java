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
public class Work2 {
 
    public void doAction() throws InterruptedException{
        for(int i=1;i<10;i++){
            System.out.println("work2 "+i);
            Thread.sleep(1000);
        }
    }
    
}
