/*
* Title: hw3_1.java
* Abstract: This script takes a string, parses the non numeric & alphabetic
* characters out, and returns true or false if the string is palindrome.
* ID: 1993
* Name: Amber Beebe
* Date: 03/22/2021
*/

import java.util.*;

public class hw3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String input = sc.nextLine();
        
        input = removeNonAlpha(input.toUpperCase(), input.length() - 1);
                
        if (isPalindrome(input)) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
    }
    
    public static boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }
        
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return isPalindrome(s.substring(1, s.length() - 1));
        }
        
        return false;
    }
    
    public static String removeNonAlpha(String s, int length) {
        if(length == -1) {
            return s;
        }
        
        if(!"1234567890".contains(s.charAt(length)+"")
            && !"ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains(s.charAt(length)+"")) {
            s = s.substring(0, length) + s.substring(length + 1, s.length());
        }
        
        return removeNonAlpha(s, --length);
    }
}