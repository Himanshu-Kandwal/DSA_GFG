/*

https://www.geeksforgeeks.org/batch/gfg-160-problems/track/hashing-gfg-160/problem/count-subarray-with-given-xor

Given an array of integers arr[] and a number k, count the number of subarrays having XOR of their elements as k.

Examples:

Input: arr[] = [4, 2, 2, 6, 4], k = 6
Output: 4
Explanation: The subarrays having XOR of their elements as 6 are [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], and [6]. Hence, the answer is 4.
Input: arr[] = [5, 6, 7, 8, 9], k = 5
Output: 2
Explanation: The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]. Hence, the answer is 2.
Input: arr[] = [1, 1, 1, 1], k = 0
Output: 4
Explanation: The subarrays are [1, 1], [1, 1], [1, 1] and [1, 1, 1, 1].
Constraints:

1 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤105
0 ≤ k ≤ 105

 */
package Hashing;

import java.util.HashMap;

public class SubarrayWithXOR_K {
    public static void main(String[] args) {
        Solution obj = new SubarrayWithXOR_K().new Solution();
        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;
        System.out.println(obj.subarrayXor(arr,k));
    }

    class Solution {

        public long subarrayXor(int arr[], int k) {

            HashMap<Integer, Integer> freq = new HashMap<>();

            int xorSoFar = 0;
            int count = 0;

            freq.put(0, 1);

            for (int num : arr) {
                xorSoFar = xorSoFar ^ num;
                if (freq.containsKey(xorSoFar ^ k)) {
                    count = count + freq.get(xorSoFar ^ k);
                }
                freq.put(xorSoFar, freq.getOrDefault(xorSoFar, 0) + 1);
            }

            return count;
        }
    }
}
