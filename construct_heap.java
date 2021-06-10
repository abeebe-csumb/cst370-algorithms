/*
* Title: hw5_1.java
* Abstract: A program that conducts heap operations
* ID: 1993
* Name: Amber Beebe
* Date: 04/12/2021
*/

import java.util.*;

class Heap {
    int[] heap;
    int size;
    int maxsize;
    
    Heap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        heap = new int[maxsize + 1];
        heap[0] = Integer.MAX_VALUE;
    }
    
    int left(int pos) { return (pos * 2); }
    
    int right(int pos) { return (pos * 2) + 1; }
    
    int parent(int pos) { return (pos/2); }
    
    private boolean isLeaf(int pos) {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }
    
    void maxHeapify(int pos) {
        if (isLeaf(pos))
            return;
            
        if(right(pos) < size && heap[right(pos)] > heap[left(pos)]) {
            if(heap[right(pos)] > heap[pos]) {
                swap(pos, right(pos));
                maxHeapify(right(pos));
            }
        } else if (heap[left(pos)] > heap[pos]) {
            swap(pos, left(pos));
            maxHeapify(left(pos));
        }
    }
    
    void swap(int pos, int x) {
        int tmp = heap[pos];
        heap[pos] = heap[x];
        heap[x] = tmp;
    }
    
    void insert(int val) {
        if(size == maxsize) {
            resizeheap(++maxsize);
        }
        
        heap[++size] = val;
        int current = size;
        // System.out.println("Before Bubble " +display());
        while (heap[current] > heap[parent(current)]) {
            // System.out.println("current " + current + ", value " + heap[current]);
            // System.out.println("parent " + parent(current) + ", value " + heap[parent(current)]);
            swap(current, parent(current));
            // System.out.println("After Bubble " + display());
            current = parent(current);
        }
    }
    
    void delete(int val) {
        int cur = 1;
        int pos = 0;
        
        while(cur <= maxsize || pos == 0) {
            if(heap[cur] == val) {
                pos = cur;
            }
            cur++;
        }
        
        System.out.println(pos);
        
        if(pos > 0) { // if value is found in heap
            heap[pos] = heap[maxsize];
            size--;
            resizeheap(maxsize--);
            maxHeapify(pos);
        }
    }
    
    void update(int index, int val) {
        heap[index+1] = val;
        
        int current = index + 1;
        while (current > 1 && heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        
        maxHeapify(current);
    }
    
    void resizeheap(int length) {
        int[] tmpheap = heap;
        heap = new int[maxsize + 1];
        for(int i = 1; i < length; i++) {
            heap[i] = tmpheap[i];
        }
    }
    
    String display() {
        String output = "";
        for(int i = 1; i < heap.length; i++) {
            output+=heap[i] + " ";
        }
        return output.trim();
    }
    
    int displayMax() {
        return heap[1];
    }
    
    int deleteMax() {
        int popped = heap[1];
        heap[1] = heap[size--];
        resizeheap(maxsize--);
        maxHeapify(1);
        return popped;
    }
}

public class hw5_1 {
    
    public static Heap hp;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int maxsize = sc.nextInt();
        hp = new Heap(maxsize);
    
        sc.nextLine();
        
        for(int i = 0; i < maxsize; i++) {
            hp.insert(sc.nextInt());
        }
        
        int  numOps = sc.nextInt();
        sc.nextLine();
        int count = 0;
        
        while(count < numOps) {
            doHeapStuff(sc.nextLine());
            count++;
        } 
    
        sc.close();
    }
    
    public static void doHeapStuff(String command) {
        String compare = "";
        int index = 0;
        int value = 0;
        if(command.contains(" ")) {
            compare = command.substring(0, command.indexOf(" "));
            if(compare.equals("update")) {
                index = Integer.parseInt(command.substring(command.indexOf(" ") + 1, command.lastIndexOf(" ")));
                value = Integer.parseInt(command.substring(command.lastIndexOf(" ") + 1, command.length()));
            } else {
                value = Integer.parseInt(command.substring(command.indexOf(" ") + 1, command.length()));
            }
        } else {
            compare = command;
        }
        
        switch(compare) {
            case "insert":
                hp.insert(value);
                break;
            case "update":
                hp.update(index, value);
                break;
            case "delete":
                hp.delete(value);
                break;
            case "display":
                System.out.println(hp.display());
                break;
            case "deleteMax":
                hp.deleteMax();
                break;
            case "displayMax":
                System.out.println(hp.displayMax());
                break;
            default:
                break;
        }
    }
}