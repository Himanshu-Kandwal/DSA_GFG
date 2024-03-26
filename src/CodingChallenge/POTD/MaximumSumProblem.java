package CodingChallenge.POTD;

import java.util.Arrays;

/*

A number n can be broken into three parts n/2, n/3, and n/4 (consider only the integer part). Each number obtained in this process can be divided further recursively. Find the maximum sum that can be obtained by summing up the divided parts together.
Note: It is possible that we don't divide the number at all.

Example 1:

Input:
n = 12
Output:
13
Explanation:
Break n = 12 in three parts {12/2, 12/3, 12/4} = {6, 4, 3}, now current sum is = (6 + 4 + 3) = 13. Further breaking 6, 4 and 3 into parts will produce sum less than or equal to 6, 4 and 3 respectively.
Example 2:

Input:
n = 24
Output:
27
Explanation:
Break n = 24 in three parts {24/2, 24/3, 24/4} = {12, 8, 6}, now current sum is = (12 + 8 + 6) = 26 . But recursively breaking 12 would produce value 13. So our maximum sum is 13 + 8 + 6 = 27.
Your Task:
You don't need to read input or print anything. Your task is to complete the function maxSum() which accepts an integer n and returns the maximum sum.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
0 <= n <= 106

 */
public class MaximumSumProblem {
    public static void main(String[] args) {
        int n = 1000;
        System.out.println(new MaximumSumProblem().new Solution().maxSum(n));
    }

    class Solution {
        public int maxSum(int n) {
            int[] memo = new int[1000000 + 1];
            Arrays.fill(memo, -1);

            return helperRecursiveDP(n, memo);
        }

        public int helperRecursiveDP(int n, int[] memo) {
            if (n <= 0) return 0; //base case
            if (memo[n] != -1) return memo[n];

            int n2 = Math.max(n / 2, helperRecursiveDP(n / 2, memo)); // max of n/2 and ans of breaking n/2 further in (n/2)/2 ,
            //  (n/2)/3 and so on, is the ans;

            int n3 = Math.max(n / 3, helperRecursiveDP(n / 3, memo));
            int n4 = Math.max(n / 4, helperRecursiveDP(n / 4, memo));

            int ans = Math.max(n, n2 + n3 + n4);  //Note: It is possible that we don't divide the number at all.
            //so may be given number 'n' itself is bigger than the sum we found

            memo[n] = ans; //saving for DP

            return memo[n];
        }

        public int helperIterativeDP(int n) { //no extra space in recursion call stack

            if(n<2) return n;

            int[] memo = new int[n + 1]; //if n=0
            memo[0] = 0;
            memo[1] = 1;

            for (int i = 2; i <= n; i++) {
                memo[i] = Math.max(i, (memo[i / 2] + memo[i / 3] + memo[i / 4]));
            }

            return memo[n];

        }
    }

}
