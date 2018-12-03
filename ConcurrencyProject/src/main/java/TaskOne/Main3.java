/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaskOne;

/**
 *
 * @author kerch
 */
public class Main3 {
    
    public static void main(String[] args) {
        
        BussinesProcessor proc = new BussinesProcessorImpl();
        int [] array = new int [1000];
        
        for (int i = 0; i < array.length; i++) {
            array[i]=i;
        }
        int calculate = proc.calculate(array);
        System.out.println(calculate);
    }
    
}
