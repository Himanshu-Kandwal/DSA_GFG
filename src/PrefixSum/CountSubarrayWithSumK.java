/*
Given an unsorted array of integers, find the number of continuous subarrays having sum exactly equal to a given number k.

Examples:

Input: arr = [10, 2, -2, -20, 10], k = -10
Output: 3
Explaination: Subarrays: arr[0...3], arr[1...4], arr[3...4] have sum exactly equal to -10.
Input: arr = [9, 4, 20, 3, 10, 5], k = 33
Output: 2
Explaination: Subarrays: arr[0...2], arr[2...4] have sum exactly equal to 33.
Input: arr = [1, 3, 5], k = 0
Output: 0
Explaination: No subarray with 0 sum.
Constraints:

1 ≤ arr.size() ≤ 105
-103 ≤ arr[i] ≤ 103
-107 ≤ k ≤ 107

 */
package PrefixSum;

import java.util.HashMap;

public class CountSubarrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        int k = -10;
        System.out.println(new CountSubarrayWithSumK().new Solution().countSubarrays(arr, k));
    }

    class Solution {

        public int countSubarrays(int[] arr, int k) {
            HashMap<Integer, Integer> freq = new HashMap<>(); // sum of array so far to index mapping
            int sumSoFar = 0;
            int count = 0;

            freq.put(0, 1); //to count sub arrays starting from beginning also

            for (int num : arr) {
                sumSoFar = sumSoFar + num;
                if (freq.containsKey(sumSoFar - k)) {
                    count = count + freq.get(sumSoFar - k);
                }

                freq.put(sumSoFar, freq.getOrDefault(sumSoFar, 0) + 1); //increase frequency

            }

            return count;
        }
    }
}
