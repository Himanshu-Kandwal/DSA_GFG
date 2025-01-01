/*
https://www.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1

Given an array arr[] of non-negative integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.

Examples:

Input: arr[] = [2, 6, 1, 9, 4, 5, 3]
Output: 6
Explanation: The consecutive numbers here are 1, 2, 3, 4, 5, 6. These 6 numbers form the longest consecutive subsquence.
Input: arr[] = [1, 9, 3, 10, 4, 20, 2]
Output: 4
Explanation: 1, 2, 3, 4 is the longest consecutive subsequence.
Input: arr[] = [15, 13, 12, 14, 11, 10, 9]
Output: 7
Explanation: The longest consecutive subsequence is 9, 10, 11, 12, 13, 14, 15, which has a length of 7.
Constraints:
1 <= arr.size() <= 105
0 <= arr[i] <= 105

 */
package Hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {


    class Solution {

        // Function to return length of longest subsequence of consecutive integers.
        public int longestConsecutive(int[] arr) {

            Set<Integer> nums = new HashSet<>();

            int min=arr[0];
            int max= arr[0];

            //adding all nums to hashset, keeping min and max num of the array in variables
            for(int num : arr){
                min = Math.min(min,num);
                max = Math.max(max,num);
                nums.add(num);
            }

            int maxLen=0; //track max length of all consecutive subsequences
            int currLen=0; //.. ... ..    ,,current , ,, , , , , , , , , , ,

            while(min<=max){ //iterating from minimum num to max num of the array

                if(nums.contains(min)) //check if curr(or min) is in hashset
                    currLen++; //if yes, increase currLen
                else currLen=0; //else make it 0 so next time we re-start counting of sequence

                maxLen = Math.max(currLen,maxLen); //update maxLen , so it always contain, maximum len of all subsequences we found so far

                min++; //iterating next consecutive number
            }

            return maxLen;
        }
    }
}
