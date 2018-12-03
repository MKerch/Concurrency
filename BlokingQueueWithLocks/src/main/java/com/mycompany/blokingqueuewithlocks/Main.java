/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.blokingqueuewithlocks;

import com.sun.org.apache.xpath.internal.axes.LocPathIterator;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author kerch
 */
public class Main {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Producer producer = new Producer(lock, condition);
        Consumer consumer = new Consumer(condition, lock, producer);
        
        producer.start();
        consumer.start();
    }
}
