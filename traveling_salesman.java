/*
* Title: hw3_2.java
* Abstract: This script permutes through every option of city to city
* routes to find the best cost path, traveling through every city.
* ID: 1993
* Name: Amber Beebe
* Date: 03/22/2021
*/

import java.util.*;

public class hw3_2 {
    
    static String originCity = "";
    static Map<String, Integer> cityMap;
    static int minTripCost = 0;
    static String bestPath = "";
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int v = sc.nextInt();
        String[] cities = new String[v - 1];
        originCity = sc.next();
        
        for(int i = 0; i < cities.length; i++) {
            cities[i] = sc.next();
        }
        
        int e = sc.nextInt();
        sc.nextLine();
        
        cityMap = new HashMap<String, Integer>();
        
        for(int j = 0; j < e; j++) {
            String next = sc.nextLine();
            int spaceIndex = next.lastIndexOf(" ");
            cityMap.put(next.substring(0, spaceIndex), Integer.parseInt(next.substring(spaceIndex + 1, next.length())));
        }
        
        Permute(cities, 0);
        
        if(minTripCost == 0) minTripCost--;
        System.out.println("Path:"+bestPath);
        System.out.println("Cost:"+minTripCost);
    }
    
    public static void Permute(String[] input, int startindex) 
    {
        int size = input.length;
        int tmpTripCost = 0;
        String tmpBestPath = "";
        boolean isPath = true;
        String c = "";
        int t = 0;

        if (size == startindex + 1)
        {
            c = originCity + " " + input[0];
            t = getKey(c);
            
            if(t > 0) {
                tmpTripCost = tmpTripCost + t;
            } else {
                isPath = false;
            }
            
            tmpBestPath = tmpBestPath + originCity + "->" + input[0] + "->";

            for (int i = 1; i < size; i++)
            {
                c = input[i - 1] + " " + input[i];
                t = getKey(c);
                if (t > 0) {
                    tmpTripCost = tmpTripCost + t; 
                } else {
                    isPath = false;
                }
                tmpBestPath = tmpBestPath + input[i] + "->";
                
            }
            c = input[input.length - 1] + " " + originCity;
            t = getKey(c);
            if(t > 0) {
                tmpTripCost = tmpTripCost + t;
            } else {
                isPath = false;
            }
            
            if((tmpTripCost <= minTripCost || minTripCost == 0) && isPath == true) {
                minTripCost = tmpTripCost;
                bestPath = tmpBestPath + originCity;
            }
        } 
        else 
        {
            for (int i = startindex; i < size; i++) 
            {
                String temp = input[i];
                input[i] = input[startindex];
                input[startindex] = temp;

                Permute(input, startindex + 1);
                temp = input[i];
                input[i] = input[startindex];
                input[startindex] = temp;
            }
        }
    }
    
    public static int getKey(String s) {
        if(cityMap.containsKey(s)) {
            return cityMap.get(s);
        }
        return 0;
    }
}