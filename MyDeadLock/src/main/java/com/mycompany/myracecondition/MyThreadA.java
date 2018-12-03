/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myracecondition;

/**
 *
 * @author kerch
 */
public class MyThreadA extends Thread{
    
    private MyDataService service;

    public MyThreadA(MyDataService service) {
        this.service = service;
        this.setName("MyThreadA");
    }

    @Override
    public void run() {
        System.out.println("MyThreadA start");
        service.makeData();
        System.out.println("MyThreadA finish");
    }
    
}
