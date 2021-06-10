/*
* Title: hw4_2.java
* Abstract: Divide and conquer algorithm to find the highest number in a list
* ID: 1993
* Name: Amber Beebe
* Date: 04/05/2021
*/

import java.util.*;

public class hw4_2 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();

        int[] vals = new int[len];
        sc.nextLine();
        
        for(int i = 0; i < len; i++) {
            vals[i] = sc.nextInt();
        }

        int x = divAndConq(vals, 0, --len);
        System.out.println(x);
    }
    
    public static int divAndConq(int[] a, int start, int end) {
        if (start == end) {
            return a[start];
        } else {
            int num1 = divAndConq (a, start, (start+end)/2);
            int num2 = divAndConq (a, (start+end)/2+1, end);
            if(num1 >= num2) {
                return num1;
            } else {
                return num2;
            }
        }
    }
}