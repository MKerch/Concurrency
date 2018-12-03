/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.blokingqueueexamples;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 *
 * @author kerch
 */
public class Main {

    public static void main(String[] args) {

        //BlockingQueue queue = new ArrayBlockingQueue(3);
        BlockingQueue queue = new SynchronousQueue();//сapacity 1
        MyConsumer consumer = new MyConsumer(queue);
        MyProducer producer = new MyProducer(queue);

        consumer.start();
        producer.start();

    }
}
