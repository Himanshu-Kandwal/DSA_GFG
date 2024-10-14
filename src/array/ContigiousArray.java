/*
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.


Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.


Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.

 */
package array;

import java.util.HashMap;
import java.util.Map;

public class ContigiousArray {
    public static void main(String[] args) {
        Solution obj = new ContigiousArray().new Solution();
        int[] array = {0, 1, 0};
        System.out.println(obj.findMaxLength(array));
        ;
    }

    class Solution {
        public int findMaxLength(int[] nums) {
            Map<Integer, Integer> ZeroOneSumToIndexMap = new HashMap<>();
            int zeroAndOnesCount = 0;
            int max = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) zeroAndOnesCount--;
                else zeroAndOnesCount++;

                if (zeroAndOnesCount == 0) {
                    max = Math.max(max, i + 1);
                }

                if (ZeroOneSumToIndexMap.containsKey(zeroAndOnesCount)) {
                    max = Math.max(max, i - ZeroOneSumToIndexMap.get(zeroAndOnesCount));
                } else ZeroOneSumToIndexMap.put(zeroAndOnesCount, i);
            }

            return max;
        }
    }

}

