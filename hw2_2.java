/*
* Title: hw2_2.java
* Abstract: 
* ID: 1993
* Name: Amber Beebe
* Date: 03/14/2021
*/

import java.util.*;

class hw2_2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int numBoxes = sc.nextInt();
        
        int[] appleBoxes = new int[numBoxes];
        
        for(int i = 0; i < numBoxes; i++) {
            appleBoxes[i] = sc.nextInt();
        }
        
        int totalApples = 0;
        String finalBoxes = "";
        
        for(int j = 0; j < Math.pow(2, numBoxes); j++) {
            String tmpBoxes = "";
            int tmpMaxApples = 0;
            
            int binaryInputs[] = decToBinary(j, numBoxes);
            boolean validBox = true;
            
            for(int k = 0; k < binaryInputs.length; k++) {
                if(binaryInputs[k] == 1) {
                    tmpMaxApples = tmpMaxApples + appleBoxes[k];
                    tmpBoxes = tmpBoxes + k + " ";
                    
                    if(k > 0) {
                        if(binaryInputs[k - 1] == binaryInputs[k]) {
                            validBox = false;
                        }
                    }
                }
            }
            if(validBox == true && tmpMaxApples > totalApples) {
                finalBoxes = tmpBoxes;
                totalApples = tmpMaxApples;
            }
        }
        
        System.out.println("Boxes:" + finalBoxes.trim());
        System.out.println("Max Apples:" + totalApples);
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