/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.timerapp;

import java.util.TimerTask;

/**
 *
 * @author kerch
 */
public class MyTask extends TimerTask{


    private String workerName;
    
    public MyTask(String workerName) {
        this.workerName = workerName;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(workerName);
        }
    }
    
}
