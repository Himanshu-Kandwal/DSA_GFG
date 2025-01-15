/*
Given an array arr[] containing integers and an integer k, your task is to find the length of the longest subarray where the sum of its elements is equal to the given value k. If there is no subarray with sum equal to k, return 0.

Examples:

Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
Output: 6
Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest subarray with a sum of 15 is 6.
Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
Output: 5
Explanation: Only subarray with sum = 15 is [-5, 8, -14, 2, 4] of length 5.
Input: arr[] = [10, -10, 20, 30], k = 5
Output: 0
Explanation: No subarray with sum = 5 is present in arr[].
Constraints:
1 ≤ arr.size() ≤ 105
-104 ≤ arr[i] ≤ 104
-109 ≤ k ≤ 109

 */
package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, -10};
        int k = 15;
        System.out.println(new LongestSubarrayWithSumK().new Solution().longestSubarray(arr,k));
    }

    class Solution {
        public int longestSubarray(int[] arr, int k) {

            int maxSubArraySize = 0;
            Map<Integer, Integer> hashMap = new HashMap<>(); //sum to idx mapping
            int sumSoFar = 0;

            hashMap.put(0, -1); // to count subarray from 0th idx

            for (int i = 0; i < arr.length; i++) {
                sumSoFar += arr[i];
                int remaining = sumSoFar - k;
                if (hashMap.containsKey(remaining)) {
                    int extraSubArraySize = hashMap.get(remaining);
                    int currSubArraySize = i - extraSubArraySize;
                    maxSubArraySize = Math.max(maxSubArraySize, currSubArraySize);
                }
                hashMap.putIfAbsent(sumSoFar, i);
            }
            return maxSubArraySize;
        }
    }

}
