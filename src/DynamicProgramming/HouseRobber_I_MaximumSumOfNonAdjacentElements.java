package DynamicProgramming;
/*

https://leetcode.com/problems/house-robber/description/

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.



Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.


Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400

 */
public class HouseRobber_I_MaximumSumOfNonAdjacentElements {
    class Solution {
        public int rob(int[] nums) {
            // return helper(nums,nums.length-1);
            // return helper(nums, new int[nums.length], nums.length - 1);
            //return helper(nums);
            return helperSpaceOptimized(nums);
        }

        // recursive solution
        // i represents home we are robbing we start from last
        public int helper(int[] nums, int i) {
            if (i < 0)
                return 0; // out of bound cant get any value

            // rob current
            int robbed = nums[i] + helper(nums, i - 2); // rob next of next home so i-2 not i-1 as we can't rob just next
            // home
            // not robbing current
            int notRobbed = helper(nums, i - 1); // not robbing curr so not adding it to value, and move to just adjecent
            // i.e i-1 to rob.

            return Math.max(robbed, notRobbed);
        }

        // memo
        public int helper(int[] nums, int memo[], int i) {
            if (i < 0)
                return 0; // out of bound cant get any value

            // rob current
            int robbed = nums[i] + helper(nums, memo, i - 2); // rob next of next home so i-2 not i-1 as we can't rob just
            // next home
            // not robbing current
            int notRobbed = helper(nums, memo, i - 1); // not robbing curr so not adding it to value, and move to just
            // adjecent i.e i-1 to rob.

            memo[i] = Math.max(robbed, notRobbed);
            return memo[i];
        }

        // tabulation
        public int helper(int[] nums) {

            int DP[] = new int[nums.length + 1];
            // shifted base case -1 to 0th index
            DP[0] = 0; // if(i<0) return 0; //out of bound cant get any value

            for (int i = 1; i <= nums.length; i++) {

                // rob current
                int robbed = nums[i - 1];
                if (i > 1) // if we can access [i-2] index
                    robbed = robbed + DP[i - 2]; // rob next of next home so i-2 not i-1 as we can't rob just next home

                // not robbing current
                int notRobbed = DP[i - 1]; // not robbing curr so not adding it to value, and move to just adjecent i.e i-1
                // to rob.

                DP[i] = Math.max(robbed, notRobbed);

            }
            return DP[nums.length]; // since dp[0] has base case. we have answer in nums.length index not
            // nums.length-1 index
        }

        // tabulation space optimized
        public int helperSpaceOptimized(int[] nums) {
            // shifted base case -1 to 0th index
            int curr= 0; // if(i<0) return 0; //out of bound cant get any value
            int prev2=0;
            int prev1=0;

            for (int i = 1; i <= nums.length; i++) {

                // rob current
                int robbed = nums[i - 1];
                if (i > 1) // if we can access [i-2] index
                    robbed = robbed + prev2; // rob next of next home so i-2 not i-1 as we can't rob just next home

                // not robbing current
                int notRobbed = prev1; // not robbing curr so not adding it to value, and move to just adjecent i.e i-1
                // to rob.

                //move prev variables
                curr = Math.max(robbed, notRobbed);
                prev2= prev1;
                prev1=curr;

            }
            return curr; // since dp[0] has base case. we have answer in nums.length index not
            // nums.length-1 index
        }


    }
}
