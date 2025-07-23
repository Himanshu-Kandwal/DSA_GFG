package array;
/*
https://www.geeksforgeeks.org/problems/sum-of-subarrays2229/1
Given an array arr[], find the sum of all the subarrays of the given array.

Note: It is guaranteed that the total sum will fit within a 32-bit integer range.

Examples:

Input: arr[] = [1, 2, 3]
Output: 20
Explanation: All subarray sums are: [1] = 1, [2] = 2, [3] = 3, [1, 2] = 3, [2, 3] = 5, [1, 2, 3] = 6. Thus total sum is 1 + 2 + 3 + 3 + 5 + 6 = 20.
Input: arr[] = [1, 3]
Output: 8
Explanation: All subarray sums are: [1] = 1, [3] = 3, [1, 3] = 4. Thus total sum is 1 + 3 + 4 = 8.
Constraints :
1 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤ 104


 */
class SumOfAllSubarrays {
    public int subarraySum(int[] arr) {
        int sum = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            // -----------------------------------------------
            // Contribution Method:
            // Instead of generating all subarrays, we calculate
            // how many subarrays include arr[i], and multiply
            // arr[i] with that count to get its total contribution.
            //
            // Total subarrays that include arr[i]:
            // = (i + 1) * (n - i)
            // where:
            // - (i + 1) is number of ways to choose a start index <= i
            // - (n - i) is number of ways to choose an end index >= i
            //
            // This gives total times arr[i] appears across all subarrays.
            // -----------------------------------------------
            int count = (i + 1) * (n - i);

            // Multiply value by its total frequency across all subarrays
            sum += count * arr[i];
        }

        // Return total sum of all subarray elements
        return sum;
    }
}

