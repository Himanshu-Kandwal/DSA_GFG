/*

Given an unsorted array of integers, find the number of continuous subarrays having sum exactly equal to a given number k.

Examples:

Input: arr = [10, 2, -2, -20, 10], k = -10
Output: 3
Explaination: Subarrays: arr[0...3], arr[1...4], arr[3...4] have sum exactly equal to -10.
Input: arr = [9, 4, 20, 3, 10, 5], k = 33
Output: 2
Explaination: Subarrays: arr[0...2], arr[2...4] have sum exactly equal to 33.
Input: arr = [1, 3, 5], k = 0
Output: 0
Explaination: No subarray with 0 sum.
Constraints:

1 ≤ arr.size() ≤ 105
-103 ≤ arr[i] ≤ 103
-107 ≤ k ≤ 107

 */
package Hashing;

import java.util.HashMap;

//todo
public class SubarrayWithSumK {
    public static void main(String[] args) {

    }

    class Solution {
        public int countSubarrays(int arr[], int k) {
            // code here
            int sum=0,ans=0;
            HashMap<Integer,Integer> mm = new HashMap<>();
            for(int x:arr){
                sum+=x;
                if(sum==k)ans++;
                ans+=mm.getOrDefault(sum-k,0);
                mm.put(sum,mm.getOrDefault(sum,0)+1);
            }
            return ans;
        }
    }
}
