/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myrunnable.example;

/**
 *
 * @author kerch
 */
public class Main {
    
    public static void main(String[] args) {
        MyHardWorker myHardWorker = new MyHardWorker();
        //myHardWorker.run();
        Thread t = new Thread(myHardWorker);
        t.start();
    }
    
}
