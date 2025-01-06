/*
Given a string in Roman number format (s), your task is to convert it to an integer. Various symbols and their values are given below.
Note: I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000

Examples:

Input: s = "IX"
Output: 9
Explanation: IX is a Roman symbol which represents 10 – 1 = 9.
Input: s = "XL"
Output: 40
Explanation: XL is a Roman symbol which represents 50 – 10 = 40.
Input: s = "MCMIV"
Output: 1904
Explanation: M is 1000, CM is 1000 – 100 = 900, and IV is 4. So we have total as 1000 + 900 + 4 = 1904.
Constraints:
1<= roman number <=3999
s[i] belongs to [I, V, X, L, C, D, M]


 */
package Hashing;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    class Solution {
        // Finds decimal value of a given roman numeral
        public int romanToDecimal(String s) {

            Map<Character,Integer> romanToDigit = new HashMap<>();

            romanToDigit.put('I',1);
            romanToDigit.put('V',5);
            romanToDigit.put('X',10);
            romanToDigit.put('L',50);
            romanToDigit.put('C',100);
            romanToDigit.put('D',500);
            romanToDigit.put('M',1000);

            if(s.length()==1) return romanToDigit.get(s.charAt(0));

            int num=0;

            for(int i=0; i< s.length()-1;i++){
                char currLetter = s.charAt(i);
                char nextLetter = s.charAt(i+1);

                int currDigit = romanToDigit.get(currLetter);
                int nextDigit = romanToDigit.get(nextLetter);

                if(currDigit<nextDigit){
                    num = num - currDigit;
                }
                else
                    num = num + currDigit;
            }


            num = num + romanToDigit.get(s.charAt(s.length()-1));

            return num;
        }
    }
}
