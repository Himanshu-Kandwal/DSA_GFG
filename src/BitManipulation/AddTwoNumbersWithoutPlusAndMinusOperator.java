package BitManipulation;

/*

https://leetcode.com/problems/sum-of-two-integers/description/
Given two integers a and b, return the sum of the two integers without using the operators + and -.



Example 1:

Input: a = 1, b = 2
Output: 3
Example 2:

Input: a = 2, b = 3
Output: 5


Constraints:

-1000 <= a, b <= 1000

 */
class AddTwoNumbersWithoutPlusAndMinusOperator {
    public int getSum(int a, int b) {
        // XOR gives sum without carry
        int sum = a ^ b;

        // AND gives carry bits, left shift by 1 to place them in correct position
        int carry = (a & b) << 1;

        // Keep adding carry until it's 0
        while (carry != 0) {
            a = sum;           // Update a to last sum
            b = carry;         // Update b to last carry

            // XOR again to get new sum without carry
            sum = a ^ b;

            // AND and shift again to get new carry
            carry = (a & b) << 1;
        }

        // Final sum when no carry remains
        return sum;
    }
}
