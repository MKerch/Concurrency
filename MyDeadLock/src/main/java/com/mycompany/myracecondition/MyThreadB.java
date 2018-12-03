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
public class MyThreadB extends Thread {

    private MyDataService service;

    public MyThreadB(MyDataService service) {
        this.service = service;
        this.setName("MyThreadB");
    }

    @Override
    public void run() {
        System.out.println("MyThreadB start");
        service.makeData();
        System.out.println("MyThreadB finish");
    }

}
