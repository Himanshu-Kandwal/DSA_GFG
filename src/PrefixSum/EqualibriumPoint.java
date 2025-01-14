/*

Given an array of integers arr[], the task is to find the first equilibrium point in the array.

The equilibrium point in an array is an index (0-based indexing) such that the sum of all elements before that index is the same as the sum of elements after it. Return -1 if no such point exists.

Examples:

Input: arr[] = [1, 2, 0, 3]
Output: 2
Explanation: The sum of left of index 2 is 1 + 2 = 3 and sum on right of index 2 is 0 + 3 = 3.
Input: arr[] = [1, 1, 1, 1]
Output: -1
Explanation: There is no equilibrium index in the array.
Input: arr[] = [-7, 1, 5, 2, -4, 3, 0]
Output: 3
Explanation: The sum of left of index 3 is -7 + 1 + 5 = -1 and sum on right of index 3 is -4 + 3 + 0 = -1.
Constraints:
3 <= arr.size() <= 106
-109 <= arr[i] <= 109

 */
package PrefixSum;

public class EqualibriumPoint {
    class Solution {
        //T(N) , S(1)
        public static int findEquilibrium(int arr[]) {

            int len = arr.length;

            int sumFromRight=0;

            for(int num : arr)
                sumFromRight+=num;

            sumFromRight-= arr[0]; //removing 0th value so its only containing sum of 1st to last number

            int sumFromLeft=arr[0]; //left sum is atleast 0th value

            for(int i=1;i<len-1;i++){
                sumFromRight-=arr[i];

                if(sumFromLeft==sumFromRight) return i;

                sumFromLeft+=arr[i];
            }

            return -1;

        }
    }
}
