package org.leetcode.palindromenumber_9;

import java.util.HashMap;

public class PalindromeNumber {
    public static void main(String[] args) {
        boolean palindrome = isPalindrome4(121);
        System.out.println("expected: true " + palindrome);
        boolean palindrome2 = isPalindrome4(-121);
        System.out.println("expected: false " + palindrome2);
        boolean palindrome3 = isPalindrome4(10);
        System.out.println("expected: false " + palindrome3);
        boolean palindrome4 = isPalindrome4(123);
        System.out.println("expected: false " + palindrome4);
    }
    //first solution easiest/shortest - but slow and requires converting to string.
    public static boolean isPalindrome(int x) {
        String xAsString = String.valueOf(x);
        String reversedString = new StringBuilder(xAsString).reverse().toString();
        return reversedString.equals(xAsString);
    }
    //second solution - using loop faster but slightly longer solution;
    public static boolean isPalindrome2(int x) {
        String xAsString = String.valueOf(x);
        for(int i = 0; i < xAsString.length()/2; i++){
            if(xAsString.charAt(i) != xAsString.charAt(xAsString.length()-i-1)){
                return false;
            }
        }
        return true;
    }
    //third solution - without transforming to string but not efficient
    public static boolean isPalindrome3(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        var number = x;
        int length = 0;
        while(x > 0){
            x /=10;
            length++;
        }
        var reversedValue = 0;
        for(int i = 1; i < length+1; i++){
            reversedValue += (int) (getNthDigit(number, i) * Math.pow(10,length-i));
        }
        return reversedValue == number;
    }

    private static int getNthDigit(int x, int n) {
        return (int) (Math.floor(x / Math.pow(10, n - 1)) % 10);
    }
    //fourth solution - without transforming to string but not efficient
    public static boolean isPalindrome4(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
