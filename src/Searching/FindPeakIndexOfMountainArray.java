package Searching;

/*

https://leetcode.com/problems/peak-index-in-a-mountain-array/

You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.

Return the index of the peak element.

Your task is to solve it in O(log(n)) time complexity.



Example 1:

Input: arr = [0,1,0]

Output: 1

Example 2:

Input: arr = [0,2,1,0]

Output: 1

Example 3:

Input: arr = [0,10,5,2]

Output: 1

Constraints:

3 <= arr.length <= 105
0 <= arr[i] <= 106
arr is guaranteed to be a mountain array.

 */

class FindPeakIndexOfMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;

        // Binary search continues while the search space has more than one element
        while (l < r) {
            int mid = l + (r - l) / 2;

            // If the mid-element is less than the next element,
            // we're on the **increasing slope** of the mountain.
            // So the peak must be to the right of mid.
            // Hence, we eliminate mid and move left boundary to mid + 1.
            if (arr[mid] < arr[mid + 1]) {
                l = mid + 1;
            } else {
                // Else we're on the **decreasing slope** of the mountain,
                // and mid could still be the peak (since it's >= next).
                // So we **keep mid** in the range and shrink the right side.
                r = mid;
            }
        }

        // When the loop ends, l == r, and it points to the only remaining element,
        // which is guaranteed to be the peak in a mountain array.
        return l; // or return r; both are equal at this point
    }
}
