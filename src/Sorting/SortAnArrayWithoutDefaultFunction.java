/*
https://leetcode.com/problems/sort-an-array/description/

Given an array of integers nums, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.



Example 1:

Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
Example 2:

Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
Explanation: Note that the values of nums are not necessairly unique.


Constraints:

1 <= nums.length <= 5 * 104
-5 * 104 <= nums[i] <= 5 * 104

 */
package Sorting;

import java.util.HashMap;

public class SortAnArrayWithoutDefaultFunction {
    class Solution {
        //using counting sort
        public int[] sortArray(int[] nums) {

            HashMap<Integer, Integer> map = new HashMap<>();
            int min = nums[0];
            int max = nums[0];

            for (int value : nums) {

                //track minimum/maximum possible element
                min = Math.min(min, value);
                max = Math.max(max, value);

                map.put(value, map.getOrDefault(value,0)+1); //storing frequency
            }

            int idx=0; //index to insert in array

            while(min<=max){
                int element=min;
                int freq = map.getOrDefault(element,0); //element in range min-max may not exist so freq is 0 for that

                for(int i=0;i<freq;i++){
                    nums[idx]=element;
                    idx++;
                }
                min++;
            }

            return nums;
        }
    }
}
