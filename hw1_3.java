/*
* Title: hw1_3.java
* Abstract: This program takes a list of strings,
*   returns a list of the maximum number of
*   combinations and their binary representations.
* ID: 1993
* Name: Amber Beebe
* Date: 03/09/2021
*/

import java.util.*;

class hw1_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int numElements = sc.nextInt();
        
        String[] inputs = new String[numElements];
        
        
        for(int i = 0; i < inputs.length; i++) {
            inputs[i] = sc.next();
        }
        
        if(numElements == 0) {
            System.out.println(numElements+":EMPTY");
        } else {
            for(int j = 0; j < Math.pow(2, numElements); j++) {
                String bin = "", vals = "";
                
                int binaryInputs[] = decToBinary(j, numElements);
                
                for(int k = 0; k < binaryInputs.length; k++) {
                    bin = bin + binaryInputs[k];
                    if(j == 0) {
                        vals = "EMPTY";
                    } else {
                        if(binaryInputs[k] == 1) {
                            vals = vals + inputs[k] + " ";
                        }   
                    }
                }
                System.out.println(bin + ":" + vals);
            }   
        }
    }
    
    public static int[] decToBinary(int n, int size) {
        int[] binaryInputs = new int[size];
        int i = size - 1;
        
        while(n > 0) {
            
            binaryInputs[i] = n % 2;
            n = n / 2;
            i--;
        }
        
        return binaryInputs;
    }
}