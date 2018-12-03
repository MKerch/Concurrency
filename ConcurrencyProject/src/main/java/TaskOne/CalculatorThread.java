/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaskOne;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kerch
 */
public class CalculatorThread extends Thread{

    private int [] data;
    private int result;
    
    public CalculatorThread(int [] data) {
        this.data=data;
    }

    @Override
    public void run() {
      int sum =0;
        for (int i : data) {
            sum+=i;
          try {
              Thread.sleep(1000);
          } catch (InterruptedException ex) {
              Logger.getLogger(CalculatorThread.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
        result=sum;
    }

    public int getResult() {
        return result;
    }
    
    
    
}
