/*
* Title: hw5_2.java
* Abstract: Perform a quick sort using two partitioned approaches
* ID: 1993
* Name: Amber Beebe
* Date: 04/12/2021
*/

import java.util.*;
import java.lang.*;

public class hw5_2 {
    static int[] randNums;
    static int size;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter input size: ");
        size = sc.nextInt();
        
        randNums = new int[size];
        for(int i = 0; i < size; i++) {
            int x = (int)Math.round(1 + (Math.random() * size));
            randNums[i] = x;
        }
        
        int[] hps = new int[size];
        System.arraycopy(randNums, 0, hps, 0, randNums.length);
        
        long startTime = System.currentTimeMillis();
        heapSort(hps);
        long endTime = System.currentTimeMillis();
        long hpsTime = endTime - startTime;
        
        int[] mgs = new int[size];
        System.arraycopy(randNums, 0, mgs, 0, randNums.length);
        
        startTime = System.currentTimeMillis();
        mergeSort(mgs, 0, size - 1);
        endTime = System.currentTimeMillis();
        long mgsTime = endTime - startTime;
        
        int[] qs = new int[size];
        System.arraycopy(randNums, 0, qs, 0, randNums.length);
        
        startTime = System.currentTimeMillis();
        quickSort(qs, 0, size - 1);
        endTime = System.currentTimeMillis();
        long qsTime = endTime - startTime;
        
        System.out.println("==================== Execution Time ====================");
        System.out.println("Heap Sort: " + hpsTime + " milliseconds");
        System.out.println("Merge Sort: " + mgsTime + " milliseconds");
        System.out.println("Quick Sort: " + qsTime + " milliseconds");
        System.out.println("========================================================");
    }
    
    public static void heapSort(int[] arr) {
        for(int i = size/2 - 1; i >= 0; i--) {
            heapify(arr, i);
        }
    }
    
    public static void heapify(int[] arr, int i) {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if(left < size && arr[left] > arr[max]) {
           max = left;
        }
        
        if(right < size && arr[right] > arr[max]) {
           max = right;
        }
        
        if(max != i) {
           int tmp = arr[i];
           arr[i] = arr[max];
           arr[max] = tmp;
           
           heapify(arr, max);
        }
    }
    
    public static void display(int[] a) {
        for(int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    static void mergeSort(int arr[],int l,int r) {
        if(l>=r){
            return;//returns recursively
        }
        int m =l+ (r-l)/2;
        mergeSort(arr,l,m);
        mergeSort(arr,m+1,r);
        merge(arr,l,m,r);
    }
    
    static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
     
        int[] L = new int[n1];
        int[] R = new int[n2];
     
        for (int i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];
     
        int i = 0;
        int j = 0;
        int k = l;
     
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
    static void quickSort(int[] arr, int low, int high) {
        if (low < high)
        {
            int pi = partition(arr, low, high);
     
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
     
        for(int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static boolean checkPos(int x) {
        return x >= 0;
    }
}