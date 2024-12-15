package org.leetcode.palindromenumber_9;

public class PalindromeNumber {
    public static void main(String[] args) {
        boolean palindrome = isPalindrome(121);
        System.out.println("expected: true " + palindrome);
        boolean palindrome2 = isPalindrome(-121);
        System.out.println("expected: false " + palindrome2);
        boolean palindrome3 = isPalindrome(10);
        System.out.println("expected: false " + palindrome3);
    }
    public static boolean isPalindrome(int x) {
        String xAsString = String.valueOf(x);
        String reversedString = new StringBuilder(xAsString).reverse().toString();
        return reversedString.equals(xAsString);
    }
}
