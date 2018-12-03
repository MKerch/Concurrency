/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaskOne;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kerch
 */
public class BussinesProcessorImpl implements BussinesProcessor {

    @Override
    public int calculate(int[] array) {
        int theadCount = array.length / 10;
        CalculatorThread[] workers = new CalculatorThread[theadCount];
        /*for (int i = 0; i < theadCount; i++) {
            int[] subData = Arrays.copyOfRange(array, 10 * i, i * 10 + 10);
            CalculatorThread thread = new CalculatorThread(subData);
            thread.start();
            workers[i] = thread;
        }*/
        for(int i=0;i<workers.length;i++){
            int[] subData = Arrays.copyOfRange(array, 10 * i, i * 10 + 10);
            workers[i] = new CalculatorThread(subData);
            workers[i].start();
        }
        
        for (CalculatorThread worker : workers) {
            try {
                worker.join();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
        int sum = 0;
        for (CalculatorThread worker : workers) {
            int result = worker.getResult();
            sum += result;
        }
        return sum;
    }

}
