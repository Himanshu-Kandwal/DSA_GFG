/*
Given an array arr[] of positive integers and another integer target. Determine if there exists two distinct indices such that the sum of there elements is equals to target.

Examples:

Input: arr[] = [1, 4, 45, 6, 10, 8], target = 16
Output: true
Explanation: arr[3] + arr[4] = 6 + 10 = 16.
Input: arr[] = [1, 2, 4, 3, 6], target = 11
Output: false
Explanation: None of the pair makes a sum of 11.
Input: arr[] = [11], target = 11
Output: false
Explanation: No pair is possible as only one element is present in arr[].
Constraints:
1 ≤ arr.size ≤ 105
1 ≤ arr[i] ≤ 105
1 ≤ target ≤ 2*105


 */
package Hashing;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    class Solution {
        boolean twoSum(int arr[], int target) {
            Set<Integer> visitedNums = new HashSet<>();

            for(int currNum : arr){
                int anotherNum = target - currNum;
                if(visitedNums.contains(anotherNum)) return true;
                else visitedNums.add(currNum);
            }

            return false;
        }
    }
}
