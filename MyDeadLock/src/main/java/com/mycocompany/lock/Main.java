/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycocompany.lock;

/**
 *
 * @author kerch
 */
public class Main {
    
    public static void main(String[] args) {
        
        MyConsumer consumer = new MyConsumer("A", "B");
        MyProducer producer = new MyProducer("A", "B");
        
        consumer.start();
        producer.start();
        
    }
    
}
