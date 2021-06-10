/*
* Title: hw6_2.java
* Abstract: 
* ID: 1993
* Name: Amber Beebe
* Date: 04/19/2021
*/

import java.util.*;

public class hw6_2 {
    static int maxheight;
    static int maxwidth;
    static int coins;
    static String path;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        maxwidth = sc.nextInt();
        maxheight = sc.nextInt();
        
        int[][] input = new int[maxheight][maxwidth];
        
        sc.nextLine();
        
        for(int i = 0; i < maxheight; i++) {
            for(int j = 0; j < maxwidth; j++) {
                input[i][j] = sc.nextInt();
            }
        }
        
        sc.close();
        
        coins = 0;
        path = "Path:";
        
        System.out.println("Max coins:" + collectCoins(input, 0,0, 1));
        
        // remove trailing arrow
        path = path.substring(0, path.length() - 2);
        System.out.println(path);
    }
    
    public static int collectCoins(int[][] arr, int x, int y, int dir) {
        if(isValid(x,y) == false || arr[x][y] == -1) {
            return 0;
        }
        
        int result = arr[x][y];
        
        path+="("+(x+1)+","+(y+1)+")->";
        
        return (result + Math.max(collectCoins(arr, x+1, y, 0), collectCoins(arr, x, y+1, 1)));
    }
    
    public static boolean isValid(int i, int j) {
        return i >= 0 && i < maxheight && j >= 0 && j < maxwidth;
    }
    
    static void display(int[][] arr) {
        for(int[] i : arr) {
            System.out.print("(");
            for(int j : i) {
                System.out.print(j + ", ");
            }
            System.out.println(")");
        }
    }
}