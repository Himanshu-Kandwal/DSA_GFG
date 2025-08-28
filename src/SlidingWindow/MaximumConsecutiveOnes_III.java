package SlidingWindow;
/*
https://leetcode.com/problems/max-consecutive-ones-iii/
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.



Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.


Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length

 */
public class MaximumConsecutiveOnes_III {
    class Solution {
        public int longestOnes(int[] arr, int k) {
            int start = 0;
            int end = 0;

            int res = 0;

            int zeros = 0;

            while (end < arr.length) {

                if (arr[end] == 0) {
                    zeros++;
                }

                //check if zeros exceeded k , move start pointer and reduce zeeros till its less or equal k

                while (zeros > k) {
                    if (arr[start] == 0) {
                        zeros--; //reduce zeros
                    }
                    start++; //keep moving start till we make zeros less than k
                }

                //calculate ans

                res = Math.max(res, end - start + 1); // length from startIdx to endIdx will be sum of both and extra 1+

                end++; //end increment for while parentloop
            }
            return res;
        }
    }
}
