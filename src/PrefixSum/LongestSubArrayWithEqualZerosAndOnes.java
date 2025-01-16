/*
Given an array arr of 0s and 1s. Find and return the length of the longest subarray with equal number of 0s and 1s.

        Examples:

        Input: arr[] = [1, 0, 1, 1, 1, 0, 0]
        Output: 6
        Explanation: arr[1...6] is the longest subarray with three 0s and three 1s.
        Input: arr[] = [0, 0, 1, 1, 0]
        Output: 4
        Explnation: arr[0...3] or arr[1...4] is the longest subarray with two 0s and two 1s.
        Input: arr[] = [0]
        Output: 0
        Explnation: There is no subarray with an equal number of 0s and 1s.
        Constraints:
        1 <= arr.size() <= 105
        0 <= arr[i] <= 1

        */

package PrefixSum;

import java.util.HashMap;

public class LongestSubArrayWithEqualZerosAndOnes {
    public static void main(String[] args) {

    }

    class Solution {

        public int maxLen(int[] arr) {
            HashMap<Integer, Integer> map = new HashMap<>();

            int currSum = 0;
            int longestSubArray = 0;
            map.put(0, -1);
            for (int i = 0; i < arr.length; i++) {
                currSum += arr[i] == 1 ? arr[i] : -arr[i];
                if (map.containsKey(currSum)) {
                    longestSubArray = Math.max(longestSubArray, i - map.get(currSum));
                }

                map.putIfAbsent(currSum, i);
            }
            return longestSubArray;
        }

    }
}
