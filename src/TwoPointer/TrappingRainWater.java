/*
https://www.geeksforgeeks.org/problems/trapping-rain-water-1587115621/0

Given an array arr[] with non-negative integers representing the height of blocks. If the width of each block is 1, compute how much water can be trapped between the blocks during the rainy season.

Examples:

Input: arr[] = [3, 0, 1, 0, 4, 0 2]
Output: 10
Explanation: Total water trapped = 0 + 3 + 2 + 3 + 0 + 2 + 0 = 10 units.

Input: arr[] = [3, 0, 2, 0, 4]
Output: 7
Explanation: Total water trapped = 0 + 3 + 1 + 3 + 0 = 7 units.
Input: arr[] = [1, 2, 3, 4]
Output: 0
Explanation: We cannot trap water as there is no height bound on both sides.
Input: arr[] = [2, 1, 5, 3, 1, 0, 4]
Output: 9
Explanation: Total water trapped = 0 + 1 + 0 + 1 + 3 + 4 + 0 = 9 units.
Constraints:
1 < arr.size() < 105
0 < arr[i] < 103


*/
package TwoPointer;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr ={3,0,1,0,4,0,2};
        System.out.println(Solution.trappingWater(arr));
    }
    class Solution {

        public int maxWater(int[] arr) {
            return (int) Solution.optimized(arr);
        }
        // arr: input array
        // n: size of array
        // Function to find the trapped water between the blocks.
        static long trappingWater(int[] arr) {
            return optimized(arr);
        }

        //optimized code , pre-compute leftMax rightMax for every block T(N), S(N)

        static long optimized(int[] arr){
            int[] leftMax = new int[arr.length];
            int[] rightMax = new int[arr.length];

            //calculate leftMax from left to right
            leftMax[0]= arr[0]; //for 0th block, leftMax is arr[0]
            for(int i=1;i<arr.length;i++){ //iterating from 1st index as 0th index wont have water contained
                leftMax[i] = Math.max(leftMax[i-1],arr[i]); // take arr[i] or previous leftMax for current block's leftMax
            }
            //rightMax calculation from right to left
            rightMax[arr.length-1]= arr[arr.length-1]; //default value is last value of arr[]

            for(int i=arr.length-2;i>=0;i--){ //iterating to second last index as last index wont have water contained
                rightMax[i] = Math.max(rightMax[i+1],arr[i]) ;
            }

            long waterContained=0;

            //calculating watercontained for all blocks and adding them to waterContained ans
            for(int i=0;i<arr.length;i++){
                long currBlockWaterContained= Math.min(leftMax[i],rightMax[i])-arr[i];
                //If the current block’s height (arr[i]) is greater than or equal to either the leftMax[i] or rightMax[i], then the calculated waterContained becomes negative.
                currBlockWaterContained = Math.max(0,currBlockWaterContained);

                waterContained+=currBlockWaterContained;
            }

            return waterContained;
        }




        //all below is unoptimized bruteforce code T(N^2), S(1);
        static long bruteForce(int[] arr){
            //add water contained at every block except first and last as they cant contain water
            long ans=0;
            for(int blockIdx=1; blockIdx<arr.length-1;blockIdx++){
                ans= ans + getWaterStoredAtBlock(blockIdx,arr);
            }

            return ans;
        }

        //method to calculate water stored at block by its index
        static long getWaterStoredAtBlock(int blockIdx, int[] arr){

            int leftMax=0, rightMax=0;
            //leftMax calculation
            for(int i=0;i<blockIdx;i++){
                leftMax= Math.max(leftMax,arr[i]);
            }

            for (int j = blockIdx + 1; j < arr.length; j++) {
                rightMax= Math.max(rightMax,arr[j]);
            }

            //water contained = min height of left/right max - height of the block

            long waterContained = Math.min(leftMax,rightMax) - arr[blockIdx];

            //return waterContained;
            //If the current block’s height (arr[blockIdx]) is greater than or equal to either the leftMax or rightMax,
            //then the calculated waterContained becomes negative.

            return Math.max(0,waterContained); //return 0 if contained water is negative
        }
    }
}

//Two pointer T(N) S(1)

class Solution {
    public int trap(int[] arr) {

        // Left and right pointers to traverse the array
        int l = 0;
        int r = arr.length - 1;

        // Variables to store the maximum height seen so far from left and right
        int lMax = 0;
        int rMax = 0;

        // Variable to store the total trapped water
        int waterTrapped = 0;

        // Traverse the array until the left and right pointers meet
        while (l <= r) {

            // If the left bar is smaller or equal to the right bar
            if (arr[l] <= arr[r]) {

                // If the current left bar is taller than lMax, update lMax
                if (arr[l] > lMax) {
                    lMax = arr[l];
                }
                // Otherwise, calculate trapped water at the current left index
                // Water trapped = lMax - height of the current bar
                else {
                    waterTrapped += lMax - arr[l];
                }

                // Move the left pointer to the right
                l++;
            }
            else { // If the right bar is smaller

                // If the current right bar is taller than rMax, update rMax
                if (arr[r] > rMax) {
                    rMax = arr[r];
                }
                // Otherwise, calculate trapped water at the current right index
                // Water trapped = rMax - height of the current bar
                else {
                    waterTrapped += rMax - arr[r];
                }

                // Move the right pointer to the left
                r--;
            }
        }

        // Return the total trapped water
        return waterTrapped;
    }
}
