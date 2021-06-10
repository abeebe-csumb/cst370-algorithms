/*
* Title: hw6_1.java
* Abstract: 
* ID: 1993
* Name: Amber Beebe
* Date: 04/19/2021
*/

import java.util.*;
//import java.utils.Arrays;

public class hw6_1 {
    public static int getMax(int[] arr, int size) {
        int max = arr[0];
        
        for(int i = 0; i < size; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    public static void countSort(int[] arr, int size, int exp) {
        int[] output = new int[size];
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);
        
        for(i = 0; i < size; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        
        for(i = 1; i < 10; i++) {
            count[i]+= count[i-1];
        }
        
        for(i = size - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[arr[i] / exp % 10]--;
        }
        
        // copy output to array
        for(i = 0; i < size; i++) {
            arr[i] = output[i];
        }
    }
    
    public static void radixSort(int[] arr, int size) {
        int max = getMax(arr, size);
        
        for(int i = 1; max / i > 0; i*=10) {
            countSort(arr, size, i);
            display(arr, size);
        }
    }
    
    public static void display(int[] arr, int size) {
        for(int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int size = sc.nextInt();
        sc.nextLine();
        
        int[] input = new int[size];
        
        for(int i = 0; i < size; i++) {
            input[i] = sc.nextInt();
        }
        
        radixSort(input, size);
    }
}