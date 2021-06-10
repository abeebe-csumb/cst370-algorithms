/*
* Title: hw1_2.java
* Abstract: This program takes two lists of integers,
*   compares the list, and returns the integers
*   which do not occur in both lists.
* ID: 1993
* Name: Amber Beebe
* Date: 03/09/2021
*/

import java.util.*;

class hw1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int length1 = sc.nextInt();
        HashSet<Integer> list1 = new HashSet<Integer>();
        
        for(int i = 0; i < length1; i++) {
            list1.add(sc.nextInt());
        }
        
        int length2 = sc.nextInt();
        HashSet<Integer> list2 = new HashSet<Integer>();
        
        for(int j = 0; j < length2; j++) {
            list2.add(sc.nextInt());
        }
        
        ArrayList<Integer> output = new ArrayList<Integer>();
        
        for (int i : list1) {
            if(!list2.contains(i)) {
                output.add(i);
            }
        }
        
        for (int i : list2) {
            if(!list1.contains(i)) {
                output.add(i);
            }
        }
        
        Collections.sort(output);
        Collections.reverse(output);
        
        String answer = "Answer:";
        if(output.size() == 0) {
            answer = answer + "NONE";
        } else {
            for(int i : output) {
                answer = answer+i+" ";
            }            
        }

        System.out.print(answer.trim());
    }
}