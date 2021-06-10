/*
* Title: hw3_3.java
* Abstract: This script performs a depth first search of a graph
* using information provided on the number of vertices and the
* edges connecting them. It prints the result, the ordered list
* of what order each vertice is touched in a connected graph.
* ID: 1993
* Name: Amber Beebe
* Date: 03/22/2021
*/

import java.util.*;

public class hw3_3 {
    
    static LinkedList<Integer> inputs[];
    static int count = 1;
    static int[] markMatrix;
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int vertLength = sc.nextInt();
        int edgeLength = sc.nextInt();
        
        inputs = new LinkedList[vertLength];
        markMatrix = new int[vertLength];
        
        for(int i = 0; i < vertLength; i++) {
            inputs[i] = new LinkedList();
        }
        
        for(int j = 0; j < edgeLength; j++) {
            int v = sc.nextInt();
            int e = sc.nextInt();
            
            inputs[v].add(e);
        }
    
        DFS(0, vertLength);
        
        displayResultsToConsole();
    }
    
    public static void DFS(int v, int vertLength) {
        boolean[] visited = new boolean[vertLength];
        DFSUtil(v, visited);
    }
    
    public static void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
    
        markMatrix[v] = count;
        count++;
        
        Iterator<Integer> iter = inputs[v].listIterator();
        
        while(iter.hasNext()) {
            int n = iter.next();
            
            if(!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }
    
    public static void displayResultsToConsole() {
        for(int i = 0; i < markMatrix.length; i++) {
            System.out.println("Mark[" + i + "]:" + markMatrix[i]);
        }
    }
}