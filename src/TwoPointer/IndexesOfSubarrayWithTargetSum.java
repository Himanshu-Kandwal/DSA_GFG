/*

Given an array arr[] containing only non-negative integers, your task is to find a continuous subarray (a contiguous sequence of elements) whose sum equals a specified value target. You need to return the 1-based indices of the leftmost and rightmost elements of this subarray. You need to find the first subarray whose sum is equal to the target.

Note: If no such array is possible then, return [-1].

Examples:

Input: arr[] = [1, 2, 3, 7, 5], target = 12
Output: [2, 4]
Explanation: The sum of elements from 2nd to 4th position is 12.
Input: arr[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], target = 15
Output: [1, 5]
Explanation: The sum of elements from 1st to 5th position is 15.
Input: arr[] = [5, 3, 4], target = 2
Output: [-1]
Explanation: There is no subarray with sum 2.
Constraints:
1 <= arr.size()<= 106
0 <= arr[i] <= 103
0 <= target <= 109


 */
package TwoPointer;

import java.util.ArrayList;

public class IndexesOfSubarrayWithTargetSum {

    class Solution {

        static ArrayList<Integer> subarraySum(int[] arr, int target) {
            ArrayList<Integer> index = new ArrayList<>();

            if (arr.length == 1) {
                if (arr[0] == target) {
                    index.add(0);
                    index.add(0);
                } else {
                    index.add(-1);
                }
                return index;
            }

            int firstIdx = 0;
            int secIdx = 0;
            int sumSoFar = 0;

            while (secIdx < arr.length) {
                sumSoFar += arr[secIdx]; // Expand the window by adding the next element

                // Check if current window sum matches the target
                while (sumSoFar > target && firstIdx <= secIdx) {
                    sumSoFar -= arr[firstIdx]; // Shrink the window by removing the leftmost element
                    firstIdx++;
                }

                // If we find the target sum, return the 1-based indices
                if (sumSoFar == target) {
                    index.add(firstIdx + 1); // Adding 1 for 1-based index
                    index.add(secIdx + 1);   // Adding 1 for 1-based index
                    return index;  // We can return immediately after finding the first match
                }

                secIdx++; // Move to the next element in the array
            }

            // If no subarray is found, return [-1]
            index.add(-1);
            return index;
        }

    }
}
