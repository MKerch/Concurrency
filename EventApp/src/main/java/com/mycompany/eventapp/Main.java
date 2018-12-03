/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eventapp;

/**
 *
 * @author kerch
 */
public class Main {
    
    public static void main(String[] args) {
        
        MyProducer produser = new MyProducer();
        MyConsumer consumer = new MyConsumer(produser);
        
        produser.setConsumer(consumer);
        
        produser.start();
        consumer.start();
        
        
    }
    
}
