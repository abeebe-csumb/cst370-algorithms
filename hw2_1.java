/*
* Title: hw2_1.java
* Abstract: 
* ID: 1993
* Name: Amber Beebe
* Date: 03/14/2021
*/

import java.util.*;
import java.lang.String;

class hw2_1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[] tz1 = sc.next().split(":");
        String[] tz2 = sc.next().split(":");
        
        int hour1 = Integer.parseInt(tz1[0]);
        int hour2 = Integer.parseInt(tz2[0]);
        
        int min1 = Integer.parseInt(tz1[1]);
        int min2 = Integer.parseInt(tz2[1]);
        
        int sec1 = Integer.parseInt(tz1[2]);
        int sec2 = Integer.parseInt(tz2[2]);
        
        int fhour, fmin, fsec;
        
        if(hour2 < hour1) {
            hour2 = hour2 + 24;
        }
        
        if(sec2 < sec1) {
            sec2 = sec2 + 60;
            min2--;
        }
        
        if(min2 < min1) {
            min2 = min2 + 60;
            hour2--;
        }
        
        fhour = hour2 - hour1;
        fmin = min2 - min1;
        fsec = sec2 - sec1;
        
        if(fhour < 10) {
            System.out.print("0" + fhour);
        } else {
            System.out.print(fhour);
        }
        
        System.out.print(":");
        
        if(fmin < 10) {
            System.out.print("0" + fmin);
        } else {
            System.out.print(fmin);
        }
        
        System.out.print(":");
        
        if(fsec < 10) {
            System.out.println("0" + fsec);
        } else {
            System.out.println(fsec);
        }
        
    }
}