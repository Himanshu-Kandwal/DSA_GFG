package CodingChallenge.Contest;
/*
You are living in Bangalore and want to travel from Bangalore to Ahmedabad and initially, you have M rupees.
You are given the cost of a Gold coin, a Silver coin and a Bronze coin in Bangalore and Ahmedabad in arrays B and A respectively.
You can buy at most one type of coin in Bangalore according to your money and sell them in Ahmedabad. You have to return the maximum money
you can have in Ahmedabad.

Example 1:
M = 8
B = {1, 1, 2}
A = {2, 1, 1}
Output: 16

Explanation:You can buy 8 gold coins in Bangalore in 8 rupees and sell them in Ahmedabad
and finally you have 16 rupees in Ahmedabad.

Example 2:
Input: M = 10
B = {15, 5, 2}
A = {6, 4, 1}
Output: 10
Explanation:It is optimal not to buy any coins in Bangalore.

Your Task: You have to complete the function MaxMoney() which takes integer M (initial money) ,
array B of length 3 represents the cost rate of coins in Bangalore and array A of length 3 represents the cost rate in Ahmedabad as input
parameters and return maximum money you can have in Ahmedabad after the transaction of <strong>at most one type coins</strong>.

Constraints:

1 <= M <= 10^5
1 <= A[i], B[i] <= 10^3

 */
public class MaximumMoney {
    public static void main(String[] args) {
        int money = 3;
        int[] B = {2, 3, 4};
        int[] A = {1, 1, 10};

        System.out.println(new MaximumMoney().new Solution().MaxMoney(money, B, A));
    }

    //User function Template for Java
    class Solution {
        public int MaxMoney(int money, int[] B, int[] A) {

            int max = money;
            int purchasedCoin = 0;

            if (money > B[0]) {
                purchasedCoin = money / B[0];
                max = Math.max(max, purchasedCoin * A[0]);
            }

            if (money > B[1]) {
                purchasedCoin = money / B[1];
                max = Math.max(max, purchasedCoin * A[1]);
            }

            if (money > B[2]) {
                purchasedCoin = money / B[2];
                max = Math.max(max, purchasedCoin * A[2]);
            }

            return max;
        }
    }
}
