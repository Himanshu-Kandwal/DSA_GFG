/*

https://www.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1

Given an array arr[] of non-negative integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.

Examples:

Input: arr[] = [2, 6, 1, 9, 4, 5, 3]
Output: 6
Explanation: The consecutive numbers here are 1, 2, 3, 4, 5, 6. These 6 numbers form the longest consecutive subsquence.
Input: arr[] = [1, 9, 3, 10, 4, 20, 2]
Output: 4
Explanation: 1, 2, 3, 4 is the longest consecutive subsequence.
Input: arr[] = [15, 13, 12, 14, 11, 10, 9]
Output: 7
Explanation: The longest consecutive subsequence is 9, 10, 11, 12, 13, 14, 15, which has a length of 7.
Constraints:
1 <= arr.size() <= 105
0 <= arr[i] <= 105

 */
package Hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {

    public static void main(String[] args) {

        int[] array = {100,4,200,1,3,2};
        LongestConsecutiveSubsequence obj = new LongestConsecutiveSubsequence();
        Solution solution = obj.new Solution();
        System.out.println(solution.longestConsecutive(array));
    }

    class Solution {
        // Function to return length of longest subsequence of consecutive integers.
        public int longestConsecutive(int[] arr) {
            if (arr.length == 0)
                return 0; // empty array
            Set<Integer> nums = new HashSet<>();

            int min = arr[0];
            int max = arr[0];

            // adding all nums to hashset, keeping min and max num of the array in variables
            for (int num : arr) {
                nums.add(num);
            }

            int maxLen = 0; // track max length of all consecutive subsequences

            for (int num : nums) {
                if (!nums.contains(num - 1)) { /*
                 * it checks if curr num is not part of any sequence we have seen eralier ,
                 * 1,5,2,3,4 if for num=1 we have countent length of sequence, we dont want
                 * to count it for num=2 since it is already included in sequnce starting
                 * from num=1
                 */
                    int curr = num;
                    int currLen = 1; // since curr num is already present in array so currlen by default is 1

                    while (nums.contains(curr + 1)) {
                        curr = curr + 1;
                        currLen++;
                    }

                    maxLen = Math.max(currLen, maxLen); // update maxLen , so it always contain, maximum len of all
                    // subsequences we found so far

                }
            }

            return maxLen;
        }
    }


}
