/*
* Title: hw1_1.java
* Abstract: This program takes two lists of integers, 
*   returns the integer most frequently occuring, 
*   and the number of occurances
* ID: 1993
* Name: Amber Beebe
* Date: 03/09/2021
*/

import java.util.*;

class hw1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] input;
        int length = sc.nextInt();
        input = new int[length];
        
        for (int i = 0; i < input.length; i++) {
            input[i] = sc.nextInt();
        }
        
        int count = 0, maxCount = 0, iter = 0;
        for(int j = 0; j < input.length; j++) {
            for(int k = 0; k < input.length; k++) {
                if(input[j] == input[k]) {
                    count++;
                }
            }
            if(count > maxCount) {
                maxCount = count;
                iter = input[j];
            }
            count = 0;
        }
        System.out.println();
        System.out.println("Number:" + iter);
        System.out.println("Frequency:" + maxCount);
    }
}