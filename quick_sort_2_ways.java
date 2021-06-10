/*
* Title: hw4_1.java
* Abstract: Perform a quick sort using two partitioned approaches
* ID: 1993
* Name: Amber Beebe
* Date: 04/05/2021
*/

import java.util.*;

public class hw4_1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int len = sc.nextInt();
        int i = 0;
        int[] val1 = new int[len];
        int[] val2 = new int[len];
        
        sc.nextLine();
        
        while(i < len) {
            val1[i] =  sc.nextInt();
            val2[i] = val1[i];
            i++;
        }
        
        sc.close();
        
        int[] firstSort = firstApproach(val1, 0, (len - 1));
        int[] secondSort = secondApproach(val2, 0, 0);
        
        arrayToString(firstSort);
        arrayToString(secondSort);
        
    }

    public static int[] firstApproach(int[] a, int i, int j) {
        if(i > j) {
            return a;
        } else {
            if(checkPos(a[i])) {
                if(checkPos(a[j])) {
                    return firstApproach(a, i, --j);
                } else {
                    return firstApproach(swap(a, i, j), i, j);    
                }
            } else {
                return firstApproach(a, ++i, j);
            }
        }
    }
    
    public static int[] secondApproach(int[] a, int i, int j) {
        if(j == a.length) {
            return a;
        } else {
            if(checkPos(a[j])) {
                return secondApproach(a, i, ++j);
            } else {
                return secondApproach(swap(a, i, j), ++i, ++j);
            }
        }
    }
    
    public static boolean checkPos(int x) {
        return x >= 0;
    }
    
    public static int[] swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        
        return a;
    }
    
    public static void arrayToString(int[] a) {
        for(int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}