/*

https://www.geeksforgeeks.org/problems/find-the-element-that-appears-once-in-sorted-array0624/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
https://leetcode.com/problems/single-element-in-a-sorted-array/

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10


Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 105

 */
package Searching;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 6, 6, 7, 7};
        SingleElementInSortedArray obj = new SingleElementInSortedArray();
        System.out.println(obj.findOnce(arr));
    }


    //Approach 1: Optimal T(N) S(1) -> Use XOR ans = ans ^ arr[i] in loop, all duplicate will be cancelled each other and only single element will be in ans variable

    //Approach 2: Optimized T(Log N) , S(1)
    /*
    All duplicate element have one on even index another copy on odd index. this pattern can be used to figure out which half portion
    we should search the single number in.

    if mid element is odd , we make it even by mid-- so we can compare mid and mid+1
    if mid and mid+1 are same, means left half is perfect, right is disrupted so search in right.
    else search in left

    basically -> if left portion is disrupted, go to right half,
    else go to left half

     */
    //for GFG
    int findOnce(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            //if mid is odd
            if (mid % 2 != 0) mid--; //make it even for comparison with next i.e mid == mid+1

            //mid is now even

            //check if even idx and odd idx have same value
            if (arr[mid] == arr[mid + 1]) { //same value means left half is not disrupted, so skip it and check right half
                start = mid + 2; //skip mid and mid+1 and consider start to be right half's start
            } else { //not same value, means right half is not disrupted , check the right half,
                end = mid;
            }
        }

        //loop terminated i.e start==end, only start/end can have the single element
        return arr[start];
    }

    //For leetcode same approach
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        // The pattern: every duplicate number appears in a pair (even index, odd index).
        // The unique number is the only one that does NOT follow this pattern.

        while (start < end) { // Continue until the search range collapses
            int mid = start + (end - start) / 2; // Find middle index

            // Ensure mid is even to correctly compare pairs (mid and mid + 1)
            if (mid % 2 == 1) {
                mid--; // If mid is odd, shift it left to make it even
            }

            // Check if mid and mid+1 are a duplicate pair (following the pattern)
            if (nums[mid] == nums[mid + 1]) {
                // The single element is in the right half, so move `start` past this pair
                start = mid + 2;
            } else {
                // The pattern is broken in the left half, so search in this region
                end = mid;
            }
        }

        // The loop stops when start == end, meaning we have found the unique element
        return nums[start];
    }


}
