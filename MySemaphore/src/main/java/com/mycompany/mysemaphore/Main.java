/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mysemaphore;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kerch
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);//mutex
        Thread a = new Thread() {
            public void run() {
                while (true) {
                    try {
                        System.out.println("run started in A");
                        semaphore.acquire();
                        System.out.println("Thread A");
                        Thread.sleep(2000);
                        System.out.println("Thread A");
                        Thread.sleep(2000);
                        System.out.println("Thread A");
                        Thread.sleep(2000);
                        semaphore.release();
                        System.out.println("run end in A");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        Thread b = new Thread() {
            public void run() {
                while (true) {
                    try {
                        System.out.println("run started in B");
                        semaphore.acquire();
                        System.out.println("Thread B");
                        Thread.sleep(2000);
                        System.out.println("Thread B");
                        Thread.sleep(2000);
                        System.out.println("Thread B");
                        Thread.sleep(2000);
                        semaphore.release();
                        System.out.println("run end in B");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        Thread c = new Thread() {
            public void run() {
                while (true) {
                    try {
                        System.out.println("run started in C");
                        semaphore.acquire();
                        System.out.println("Thread C");
                        Thread.sleep(2000);
                        System.out.println("Thread C");
                        Thread.sleep(2000);
                        System.out.println("Thread C");
                        Thread.sleep(2000);
                        semaphore.release();
                        System.out.println("run end in C");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        a.start();
        b.start();
        c.start();

    }

}
