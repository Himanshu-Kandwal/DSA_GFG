package array;

/*

https://leetcode.com/problems/sum-of-all-odd-length-subarrays/description/

Given an array of positive integers arr, return the sum of all possible odd-length subarrays of arr.

A subarray is a contiguous subsequence of the array.

Example 1:

Input: arr = [1,4,2,5,3]
Output: 58
Explanation: The odd-length subarrays of arr and their sums are:
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[1,4,2,5,3] = 15
If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
Example 2:

Input: arr = [1,2]
Output: 3
Explanation: There are only 2 subarrays of odd length, [1] and [2]. Their sum is 3.
Example 3:

Input: arr = [10,11,12]
Output: 66


Constraints:

1 <= arr.length <= 100
1 <= arr[i] <= 1000


Follow up:

Could you solve this problem in O(n) time complexity?

 */
public class SumOfOddLengthSubArray {

    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            // -------------------------------------------------------------
            // Contribution Method for Odd-Length Subarrays:
            //
            // For arr[i], total number of subarrays it appears in:
            //     = (i + 1) * (n - i)
            //
            // Out of those, how many are of odd length?
            // Roughly half of them — use integer math to estimate:
            //     oddSubarrays = ((i + 1) * (n - i) + 1) / 2
            //
            // This gives us the number of *odd-length* subarrays
            // where arr[i] contributes, so multiply by arr[i].
            // -------------------------------------------------------------

            int numberOfOddLengthSubArraysContainingI = ((i + 1) * (arr.length - i) + 1) / 2;

            // Add the contribution of arr[i] to the final sum
            sum += numberOfOddLengthSubArraysContainingI * arr[i];
        }

        // Return the total sum of all odd-length subarray elements
        return sum;
    }

}
