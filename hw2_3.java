/*
* Title: hw2_3.java
* Abstract: 
* ID: 1993
* Name: Amber Beebe
* Date: 03/14/2021
*/

import java.util.*;

class hw2_3 {
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        int verticesLength = sc.nextInt();
        int edgeLength = sc.nextInt();
        
        int[][] verticesMatrix = new int[verticesLength][verticesLength];
        
        for(int i = 0; i < edgeLength; i++) {
            verticesMatrix[sc.nextInt()][sc.nextInt()] = 1;
        }

        for(int j = 0; j < verticesMatrix.length; j++) {
            System.out.print(j);
            for(int k = 0; k < verticesMatrix[j].length; k++) {
                if(verticesMatrix[j][k] == 1) {
                    System.out.print("->" + k);
                }
            }
            System.out.println();
        }
    }
}