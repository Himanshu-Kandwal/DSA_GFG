/*

https://www.geeksforgeeks.org/problem-of-the-day?utm_source=practice_header&utm_medium=practice

Given an array arr[] of non-negative integers, the task is to find the length of the Longest Strictly Increasing Subsequence (LIS).

A subsequence is strictly increasing if each element in the subsequence is strictly less than the next element.

Examples:

Input: arr[] = [5, 8, 3, 7, 9, 1]
Output: 3
Explanation: The longest strictly increasing subsequence could be [5, 7, 9], which has a length of 3.
Input: arr[] = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
Output: 6
Explanation: One of the possible longest strictly increasing subsequences is [0, 2, 6, 9, 13, 15], which has a length of 6.
Input: arr[] = [3, 10, 2, 1, 20]
Output: 3
Explanation: The longest strictly increasing subsequence could be [3, 10, 20], which has a length of 3.
Constraints:
1 ≤ arr.size() ≤ 103
0 ≤ arr[i] ≤ 106

 */
package DynamicProgramming;

public class LongestIncreasingSubsequence {
    class Solution {
        static int lis(int arr[]) {
            int dp[][] = new int[arr.length+1][arr.length+1];
            return helper(arr,dp, -1,0); //prev is -1 so by default we are not taking any element
        }

        static int helper(int arr[],int dp[][], int prevIdx, int currIdx) {
            if(currIdx>=arr.length){
                return 0;
            }

            if(dp[prevIdx+1][currIdx]!=0) return dp[prevIdx+1][currIdx];

            int include=0;
            //if no prev ,then include OR if prev is smaller than curr, include now also
            if(prevIdx==-1 || arr[prevIdx]<arr[currIdx]){
                include = 1 + helper(arr,dp,currIdx,currIdx+1); //+1 ffor including curr element and + ans of remaining array
            }

            int exclude= helper(arr,dp,prevIdx,currIdx+1); //not taking any value, so not adding any thing to ans,  just move to next element to get ans

            dp[prevIdx+1][currIdx]= Math.max(include,exclude); //returning maximum
            return dp[prevIdx+1][currIdx];
        }
    }
}
