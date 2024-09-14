/*
https://www.geeksforgeeks.org/problems/optimal-strategy-for-a-game-1587115620/1

You are given an array arr of size n. The elements of the array represent n coin of values v1, v2, ....vn. You play against an opponent in an alternating way. In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the value of the coin.
You need to determine the maximum possible amount of money you can win if you go first.
Note: Both the players are playing optimally.

Example 1:

Input:
n = 4
arr[] = {5, 3, 7, 10}
Output:
15
Explanation: The user collects maximum
value as 15(10 + 5). It is guarantee that we cannot get more than 15 by any possible moves.
Example 2:

Input:
n = 4
arr[] = {8, 15, 3, 7}
Output:
22
Explanation: The user collects maximum
value as 22(7 + 15). It is guarantee that we cannot get more than 22 by any possible moves.
Your Task:
Complete the function maximumAmount() which takes an integer n as a number of coins and an array arr[] (represent values of n coins) as a parameter and returns the maximum possible amount of money you can win if you go first.

Expected Time Complexity : O(n*n)
Expected Auxiliary Space: O(n*n)

Constraints:
2 <= n <= 103
1 <= arr[i] <= 106

 */
package CodingChallenge.POTD;


public class OptimalStrategyForAGame {
    public static void main(String[] args) {
        int n = 4;
        int[] arr = {5, 3, 7, 10};
        System.out.println(solve.maximumAmount(arr,n));
    }
}

class solve
{

    static long maximumAmount(int arr[], int n)
    {
        long memo[][]= new long[n][n];

        return countMaximumHelperTabulation(n,arr);
        //return countMaximumHelperMemo(0,n-1,arr,memo); //it works but uses recursion
    }

    static long countMaximumHelper(int startIdx,int endIdx,int arr[])
    {

        if(startIdx>endIdx) return 0;


        //I chose end, he chose end
        long choosenEnd1 = arr[endIdx]   + countMaximumHelper(startIdx,endIdx-2,arr);
        //I chose end he chose start
        long choosenEnd2 = arr[endIdx]   + countMaximumHelper(startIdx+1,endIdx-1,arr);

        //I chose start , he chose start
        long choosenStart1 = arr[startIdx] + countMaximumHelper(startIdx+2,endIdx,arr);
        //I chose start , he chose end
        long choosenStart2 = arr[startIdx] + countMaximumHelper(startIdx+1,endIdx-1,arr);


        long maxStart= Math.min(choosenStart1,choosenStart2);
        long maxEnd  = Math.min(choosenEnd1,choosenEnd2);

        return Math.max(maxStart,maxEnd);
    }


    static long countMaximumHelperMemo(int startIdx,int endIdx,int arr[],long [][] memo)
    {

        if(startIdx>endIdx) return 0;

        if(memo[startIdx][endIdx]>0) return memo[startIdx][endIdx];

        //I chose end, he chose end
        long choosenEnd1 = arr[endIdx]   + countMaximumHelperMemo(startIdx,endIdx-2,arr,memo);
        //I chose end he chose start
        long choosenEnd2 = arr[endIdx]   + countMaximumHelperMemo(startIdx+1,endIdx-1,arr,memo);

        //I chose start , he chose start
        long choosenStart1 = arr[startIdx] + countMaximumHelperMemo(startIdx+2,endIdx,arr,memo);
        //I chose start , he chose end
        long choosenStart2 = arr[startIdx] + countMaximumHelperMemo(startIdx+1,endIdx-1,arr,memo);


        long maxStart= Math.min(choosenStart1,choosenStart2);
        long maxEnd  = Math.min(choosenEnd1,choosenEnd2);

        memo[startIdx][endIdx] = Math.max(maxStart,maxEnd);

        return memo[startIdx][endIdx];
    }

    //Tabulation

    static long countMaximumHelperTabulation(int n, int arr[]) {
        long dp[][] = new long[n][n];

        for (int len = 1; len <= n; len++) {
            for (int startIdx = 0; startIdx + len <= n; startIdx++) {
                int endIdx = startIdx + len - 1;

                if (len == 1) {
                    dp[startIdx][endIdx] = arr[startIdx];
                } else if (len == 2) {
                    dp[startIdx][endIdx] = Math.max(arr[startIdx], arr[endIdx]);
                } else {
                    long choosenEnd1 = arr[endIdx] + dp[startIdx][endIdx - 2];
                    long choosenEnd2 = arr[endIdx] + dp[startIdx + 1][endIdx - 1];
                    long choosenStart1 = arr[startIdx] + dp[startIdx + 2][endIdx];
                    long choosenStart2 = arr[startIdx] + dp[startIdx + 1][endIdx - 1];

                    dp[startIdx][endIdx] = Math.max(Math.min(choosenStart1, choosenStart2),
                            Math.min(choosenEnd1, choosenEnd2));
                }
            }
        }

        return dp[0][n - 1];
    }

}

