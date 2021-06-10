/*
* Title: hw4_3.java
* Abstract: Performs topological sorting based on Kahn's algorithm
* ID: 1993
* Name: Amber Beebe
* Date: 04/05/2021
*/

import java.util.*;

public class hw4_3 {
    static int v;
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        v = sc.nextInt();
        int e = sc.nextInt();
        
        List<Integer> graph[] = new ArrayList[v];
        
        for(int i = 0; i < v; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        int j = 0;
        while(j < e) {
            graph[sc.nextInt()].add(sc.nextInt());
            j++;
        }
        
        topologicalSort(graph);
    }
    
    public static void topologicalSort(List<Integer>[] g) {
        int[] indegree = new int[v];
        
        for(int i = 0; i < v; i++) {
            ArrayList<Integer> tmp = (ArrayList<Integer>)g[i];
            for(int j : tmp) {
                indegree[j]++;
            }
        }
        
        for(int i = 0; i < v; i++) {
            System.out.println("In-degree["+i+"]:"+indegree[i]);
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        
        for(int i = 0; i < v; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        
        int count = 0;
        
        Vector<Integer> topOrder = new Vector<Integer>();
        
        while(!q.isEmpty()) {
            int u = q.poll();
            topOrder.add(u);
            
            for(int node : g[u]) {
                if(--indegree[node] == 0) {
                    q.add(node);
                }
            }
            count++;
        }
        
        if(count != g.length) {
            System.out.println("No Order:");
            return;
        }
        
        int iter = 0;
        System.out.print("Order:");
        for(int i : topOrder) {
            if(iter < v - 1) {
                System.out.print(i + "->");   
            } else {
                System.out.print(i);
            }
            
            iter++;
        }
        System.out.println();
    }
}