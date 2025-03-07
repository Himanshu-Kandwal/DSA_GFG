/*
https://www.geeksforgeeks.org/problems/geek-jump/1
Given an integer array height[] where height[i] represents the height of the i-th stair, a frog starts from the first stair and wants to reach the top. From any stair i, the frog has two options: it can either jump to the (i+1)th stair or the (i+2)th stair. The cost of a jump is the absolute difference in height between the two stairs. Determine the minimum total cost required for the frog to reach the top.

Example:

Input: heights[] = [20, 30, 40, 20]
Output: 20
Explanation:  Minimum cost is incurred when the frog jumps from stair 0 to 1 then 1 to 3:
jump from stair 0 to 1: cost = |30 - 20| = 10
jump from stair 1 to 3: cost = |20-30|  = 10
Total Cost = 10 + 10 = 20
Input: heights[] = [30, 20, 50, 10, 40]
Output: 30
Explanation: Minimum cost will be incurred when frog jumps from stair 0 to 2 then 2 to 4:
jump from stair 0 to 2: cost = |50 - 30| = 20
jump from stair 2 to 4: cost = |40-50|  = 10
Total Cost = 20 + 10 = 30
Constraints:

1 <= height.size() <= 105
0 <= height[i]<=104

 */
package DynamicProgramming;

public class FrogJump {
    class Solution {

        int minCost(int[] height) {
            //return helper(height,0);
            return helperDP(height);
        }

        //recursive
        int helperRecursive(int[] height, int currIdx) {

            //reached destination so no cost
            if(currIdx==height.length-1){
                return 0;
            }

            int cost1 = Integer.MAX_VALUE; //default value incase we can't take 1 step, so it won't be included in answer
            //can take 1 step jump
            if(currIdx+1 < height.length){
                cost1 = Math.abs(height[currIdx] - height[currIdx+1]) + helperRecursive(height,currIdx+1);
            }

            int cost2 = Integer.MAX_VALUE;
            //can take 2 step jump
            if(currIdx+2 < height.length){
                cost2 = Math.abs(height[currIdx] - height[currIdx+2]) + helperRecursive(height,currIdx+2);
            }

            return Math.min(cost1,cost2);

        }

        //memoized
        int helper(int[] height,int memo[], int currIdx) {

            //reached destination so no cost
            if(currIdx==height.length-1){
                return 0;
            }

            //beyond destination
            if(currIdx>=height.length){
                return Integer.MAX_VALUE;
            }

            //check already computed
            if(memo[currIdx]!=-1) return memo[currIdx];

            int cost1 = Integer.MAX_VALUE; //default value incase we can't take 1 step, so it won't be included in answer
            //can take 1 step jump
            if(currIdx+1 < height.length){
                cost1 = Math.abs(height[currIdx] - height[currIdx+1]) + helper(height,memo,currIdx+1);
            }

            int cost2 = Integer.MAX_VALUE;
            //can take 2 step jump
            if(currIdx+2 < height.length){
                cost2 = Math.abs(height[currIdx] - height[currIdx+2]) + helper(height,memo,currIdx+2);
            }

            memo[currIdx]= Math.min(cost1,cost2); //saving in memo

            return memo[currIdx];
        }

        //tabulation
        int helperDP(int [] height){

            int [] memo = new int[height.length];
            memo[height.length-1] = 0;

            for(int i=height.length-2;i>=0;i--){

                int cost1 = Integer.MAX_VALUE; //default value in case we can't take 1 step, so it won't be included in answer
                //can take 1-step jump
                if(i+1 < height.length){
                    cost1 = Math.abs(height[i] - height[i+1]) + memo[i+1];
                }

                int cost2 = Integer.MAX_VALUE;
                //can take 2-step jump
                if(i+2 < height.length){
                    cost2 = Math.abs(height[i] - height[i+2]) + memo[i+2];
                }

                memo[i]= Math.min(cost1,cost2); //saving in memo

            }

            return memo[0];
        }

        //tabulation + Space optimization
        int helperSpaceOptimizedDP(int [] height) {
            int n = height.length;
            int next1 = 0;  // memo[n-1] = 0 (base case)
            int next2 = 0;  // memo[n] is out of bounds, but effectively treated as 0

            for (int i = n - 2; i >= 0; i--) {
                int cost1 = Math.abs(height[i] - height[i+1]) + next1;

                int cost2 = Integer.MAX_VALUE;
                if (i + 2 < n) {
                    cost2 = Math.abs(height[i] - height[i+2]) + next2;
                }

                int current = Math.min(cost1, cost2);

                // Move variables forward
                next2 = next1;
                next1 = current;
            }

            return next1;
        }


    }
}
