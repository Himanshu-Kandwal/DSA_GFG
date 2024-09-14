/*

https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1

Given an array arr of n positive integers, your task is to find all the leaders in the array. An element of the array is considered a leader if it is greater than all the elements on its right side or if it is equal to the maximum element on its right side. The rightmost element is always a leader.

Examples

Input: n = 6, arr[] = {16,17,4,3,5,2}
Output: 17 5 2
Explanation: Note that there is nothing greater on the right side of 17, 5 and, 2.
Input: n = 5, arr[] = {10,4,2,4,1}
Output: 10 4 4 1
Explanation: Note that both of the 4s are in output, as to be a leader an equal element is also allowed on the right. side
Input: n = 4, arr[] = {5, 10, 20, 40}
Output: 40
Explanation: When an array is sorted in increasing order, only the rightmost element is leader.
Input: n = 4, arr[] = {30, 10, 10, 5}
Output: 30 10 10 5
Explanation: When an array is sorted in non-increasing order, all elements are leaders.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 <= n <= 107
0 <= arr[i] <= 107


 */
package array;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        System.out.println(Solution.leaders(9, arr));
    }
}

class Solution {
    // Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int n, int[] arr) {
        return leadersOptimized(arr);
    }

    //brute force T(n^2) S(n)
    static ArrayList<Integer> leadersBruteforce(int[] arr) {
        ArrayList<Integer> leaders = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) { // loop to pick value
            boolean isNumSmallerThanAnyNumbersInRightSide = false;
            for (int j = i + 1; j < arr.length; j++) { // loop to compare picked value with all values in the right
                if (arr[i] < arr[j]) { //if even picked value is bigger than even one number in right, we break loop
                    isNumSmallerThanAnyNumbersInRightSide = true;
                    break;
                }
            }

            //if picked number is not smaller than any number in the right then its leader and add it to list
            if (!isNumSmallerThanAnyNumbersInRightSide)
                leaders.add(arr[i]);

        }

        return leaders;
    }

    //optimized T(n) S(n)
    static ArrayList<Integer> leadersOptimized(int[] arr) {
        ArrayList<Integer> leaders = new ArrayList<>();
        leaders.add(arr[arr.length - 1]); //last value is already leader

        int maxFromRight = arr[arr.length - 1]; // last item is default value

        //iterate from 2nd last item to keep track of right most element
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] >= maxFromRight) { //check if it is greater than the maximum from right
                leaders.add(arr[i]);
            }
            maxFromRight = Math.max(maxFromRight, arr[i]); //update maxFromRight if current value is bigger than this
        }

        Collections.reverse(leaders);
        return leaders;
    }

}



