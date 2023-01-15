package Recursion;

import java.util.Scanner;
/*
We are given a string we have to find if it is palindrome or not
*/

public class PailindromeCheck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(isPalindrome(str));
    }

    static boolean isPalindrome(String str) {
        return isPalindrome(str, 0, str.length() - 1);
    }

    //T(N)
    static boolean isPalindrome(String str, int start, int end) {
        if (start <= 0 && end <= 0) return false; //invalid start and end
        if (start >= end) return true; // start and end has met
        //check if curr start and end are equal as well as for further indexes string is palindrome or not return true or false accordingly
        return str.charAt(start) == str.charAt(end) && isPalindrome(str, start + 1, end - 1);
    }

}
