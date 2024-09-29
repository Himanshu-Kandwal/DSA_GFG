package DynamicProgramming;
/*
There is an array arr of heights of stone and Geek is standing at the first stone and can jump to one of the following: Stone i+1, i+2, ... i+k stone, where k is the maximum number of steps that can be jumped and cost will be |hi-hj| is incurred, where j is the stone to land on. Find the minimum possible total cost incurred before the Geek reaches the last stone.

Example:

Input: k = 3, arr[]= [10, 30, 40, 50, 20]
Output: 30
Explanation: Geek will follow the path 1->2->5, the total cost would be | 10-30| + |30-20| = 30, which is minimum
Input: k = 1, arr[]= [10, 20, 10]
Output: 20
Explanation: Geek will follow the path 1->2->3, the total cost would be |10 - 20| + |20 - 10| = 20.
Expected Time Complexity: O(n*k)
Expected Auxilary Space: O(n)

Constraint:
1<= arr.size() <=104
1 <= k <= 100
1 <= arr[i] <= 104
*/

import java.util.Arrays;

public class MinimalCost {
    public static void main(String[] args) {
        Solution obj = new MinimalCost().new Solution();
        int k = 2;
        int arr[] = {35, 1, 70, 25, 79, 59, 63, 65};
        System.out.println(obj.minimizeCost(k, arr));
    }

    class Solution {

        public int minimizeCost(int k, int arr[]) {
            //return helper(arr,0,k); //    //current positoon is 0 default

            //memoization
        /*int memo[] = new int[arr.length-1];
        Arrays.fill(memo,-1);
        return helperMemo(arr,0,k,memo);*/

            //tabulation
            return helperTabulation(arr, k);

        }

        public int helper(int arr[], int currPosition, int k) {

            if (arr.length == 1) return arr[0];
            if (currPosition == arr.length - 1) return 0; //reached destination

            if (currPosition >= arr.length) return Integer.MAX_VALUE; //out of bounds

            int ans = Integer.MAX_VALUE;
            int currCost = 0;

            for (int i = 1; i <= k; i++) {
                if ((currPosition + i) < arr.length) {
                    int jumpCost = Math.abs(arr[currPosition] - arr[currPosition + i]); //jumped and cost will be |hi-hj| is incurred, where j is the stone to land on.

                    currCost = jumpCost + helper(arr, currPosition + i, k);
                    //update ans

                    ans = Math.min(ans, currCost);
                }
            }

            return ans;
        }

        //T(N*K) S(N)+S(N)= S(N) recursive call stack added extra S(N)
        public int helperMemo(int arr[], int currPosition, int k, int memo[]) {

            if (arr.length == 1) return arr[0];
            if (currPosition == arr.length - 1) return 0; //reached destination

            if (currPosition >= arr.length) return Integer.MAX_VALUE; //out of bounds

            if (memo[currPosition] != -1) return memo[currPosition];

            int ans = Integer.MAX_VALUE;
            int currCost = 0;

            for (int i = 1; i <= k; i++) {

                if ((currPosition + i) < arr.length) {
                    int jumpCost = Math.abs(arr[currPosition] - arr[currPosition + i]); //jumped and cost will be |hi-hj| is incurred, where j is the stone to land on.

                    currCost = jumpCost + helperMemo(arr, currPosition + i, k, memo);
                    //update ans

                    ans = Math.min(ans, currCost);
                }

            }

            return memo[currPosition] = ans;
        }

        //T(N*K) S(N)
        public int helperTabulation(int arr[], int k) {
            int dp[] = new int[arr.length];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;

            for (int position = 1; position < arr.length; position++) {

                for (int step = 1; step <= k; step++) {
                    if ((position - step) >= 0) {
                        int jumpCost = Math.abs(arr[position] - arr[position - step]);
                        dp[position] = Math.min(dp[position], dp[position - step] + jumpCost);
                    }
                }
            }

            return dp[arr.length - 1];
        }

    }
}
