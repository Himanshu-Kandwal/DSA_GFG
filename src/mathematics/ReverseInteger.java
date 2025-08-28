package mathematics;

/*
https://leetcode.com/problems/reverse-integer/description/
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).



Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21


Constraints:

-231 <= x <= 231 - 1

 */
public class ReverseInteger {
    class Solution {
        public int reverse(int x) {

            int reversedNum = 0;

            while (x != 0) {
                int lastDigit = x % 10; //last digit from original
                x = x / 10; //removed last digit fro original

                //check till now we have reversedNum in range [-231, 231 - 1] or not
                // only then we will add lastDigit in it, otherwise overflow
                //we check before we reach all digit's allowed in int range, i.e int range divide by 10 is checked so if it's in range we can add last digit

                /*
Integer.MAX_VALUE = 2147483647
Integer.MAX_VALUE / 10 = 214748364
Integer.MIN_VALUE = -2147483648
Integer.MIN_VALUE / 10 = -214748364
                 */
                //for +ve
                if (reversedNum > Integer.MAX_VALUE / 10 || (reversedNum == Integer.MAX_VALUE && lastDigit > 7)) {
                    return 0; //can't reverse return 0
                }

                //for -ve
                if (reversedNum < Integer.MIN_VALUE / 10 || (reversedNum == Integer.MIN_VALUE && lastDigit < -8)) {
                    return 0; //can't reverse return 0
                }

                reversedNum = (reversedNum * 10) + lastDigit;

            }

            return reversedNum;

        }
    }
}
