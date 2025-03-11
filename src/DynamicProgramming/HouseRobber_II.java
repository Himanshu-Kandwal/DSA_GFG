package DynamicProgramming;
/*
https://leetcode.com/problems/house-robber-ii/description/
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.



Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:

Input: nums = [1,2,3]
Output: 3


Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 1000

 */
public class HouseRobber_II {
    class Solution {
        public int rob(int[] nums) {

            if (nums.length == 1) return nums[0];

            int skipFirst = helperSpaceOptimized(nums, 1, nums.length - 1);
            int skipEnd = helperSpaceOptimized(nums, 0, nums.length - 2);
            return Math.max(skipFirst, skipEnd);
        }

        public int helperSpaceOptimized(int[] nums, int start, int end) {
            if (start > end) return 0; // Invalid range

            int curr = 0;
            int prev2 = 0;
            int prev1 = 0;

            for (int i = start; i <= end; i++) {
                // rob current house
                int robbed = nums[i];
                if (i > start) // if we can access [i-2] index
                    robbed += prev2; // rob next of next home

                // not robbing current
                int notRobbed = prev1;

                // move prev variables
                curr = Math.max(robbed, notRobbed);
                prev2 = prev1;
                prev1 = curr;
            }
            return curr;
        }

    }
}
