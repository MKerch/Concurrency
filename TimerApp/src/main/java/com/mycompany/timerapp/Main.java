/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.timerapp;

import java.util.Timer;

/**
 *
 * @author kerch
 */
public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        
        Timer timer = new Timer();
        MyTask a = new MyTask("a");
        MyTask b = new MyTask("b");
        MyTask c = new MyTask("c");
        
//        timer.schedule(a, 1000);
//        timer.schedule(b, 1000);
//        timer.schedule(c, 1000);
//        Thread.sleep(20000);
//        timer.cancel();
        

        timer.scheduleAtFixedRate(a, 2000, 1000);
        timer.scheduleAtFixedRate(b, 2000, 1500);
        timer.scheduleAtFixedRate(c, 2000, 2000);
        //a.cancel();
        
    }
    
}
