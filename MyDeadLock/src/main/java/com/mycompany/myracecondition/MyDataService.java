/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myracecondition;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kerch
 */
public class MyDataService  {

    public synchronized void makeData() {
        try {
            System.out.println("\t Make data start " + Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println("\t Make data finish " + Thread.currentThread().getName());
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

}
