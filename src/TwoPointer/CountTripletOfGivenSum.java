/*
https://www.geeksforgeeks.org/batch/gfg-160-problems/track/two-pointer-technique-gfg-160/problem/count-all-triplets-with-given-sum-in-sorted-array
Given a sorted array arr[] and a target value, the task is to count triplets (i, j, k) of valid indices, such that arr[i] + arr[j] + arr[k] = target and i < j < k.

Examples:

Input: arr[] = [-3, -1, -1, 0, 1, 2], target = -2
Output: 4
Explanation: Two triplets that add up to -2 are:
arr[0] + arr[3] + arr[4] = (-3) + 0 + (1) = -2
arr[0] + arr[1] + arr[5] = (-3) + (-1) + (2) = -2
arr[0] + arr[2] + arr[5] = (-3) + (-1) + (2) = -2
arr[1] + arr[2] + arr[3] = (-1) + (-1) + (0) = -2
Input: arr[] = [-2, 0, 1, 1, 5], target = 1
Output: 0
Explanation: There is no triplet whose sum is equal to 1.
Constraints:
3 ≤ arr.size() ≤ 104
-105 ≤ arr[i], target ≤ 105


 */
package TwoPointer;

public class CountTripletOfGivenSum {
    class Solution {
        public int countTriplets(int[] arr, int target) {
            // Code Here
            int ans = 0, size = arr.length;
            for (int i = 0; i < size; i++) {
                int j = i + 1, k = size - 1;
                while (j < k) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if (sum < target) {
                        j++;
                    } else if (sum > target) {
                        k--;
                    } else {
                        int e1 = arr[j], e2 = arr[k], c1 = 0, c2 = 0;
                        while (j <= k && arr[j] == e1) {
                            c1++;
                            j++;
                        }

                        while (j <= k && arr[k] == e2) {
                            c2++;
                            k--;
                        }
                        if (e1 == e2) {
                            ans += (c1 * (c1 - 1)) / 2;
                        } else {
                            ans += c1 * c2;
                        }
                    }
                }
            }
            return ans;
        }
    }
}
