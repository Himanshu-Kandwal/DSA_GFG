/*

https://www.geeksforgeeks.org/problems/container-with-most-water0535/1

Given an array arr[] of non-negative integers, where each element arr[i] represents the height of the vertical lines, find the maximum amount of water that can be contained between any two lines, together with the x-axis.

Note: In the case of a single vertical line it will not be able to hold water.

Examples:

Input: arr[] = [1, 5, 4, 3]
Output: 6
Explanation: 5 and 3 are 2 distance apart. So the size of the base is 2. Height of container = min(5, 3) = 3. So, total area to hold water = 3 * 2 = 6.
Input: arr[] = [3, 1, 2, 4, 5]
Output: 12
Explanation: 5 and 3 are 4 distance apart. So the size of the base is 4. Height of container = min(5, 3) = 3. So, total area to hold water = 4 * 3 = 12.
Input: arr[] = [2, 1, 8, 6, 4, 6, 5, 5]
Output: 25
Explanation: 8 and 5 are 5 distance apart. So the size of the base is 5. Height of container = min(8, 5) = 5. So, the total area to hold water = 5 * 5 = 25.
Constraints:
1<= arr.size() <=105
1<= arr[i] <=104


 */
package TwoPointer;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 3};
        System.out.println(new ContainerWithMostWater().new Solution().maxWater(arr));
    }

    /*
    Approach: take maxwater variable and take two pointers on both ends of the array,

    loop
        {
        calculate area width*height
    where width is right-left and height is min(arr[left], arr[right]) because container can store water to the smallest wall height,
    everytime we calculate area/water we update maxwater variable to hold max area/water content.
    for next iteration of loop move pointer having small value as we cant move pointer having large value.
    }

    return maxwater variable.
     */
    class Solution {

        //T(n) S(1)
        public int maxWater(int[] arr) {
            int maxWater = 0;

            int left = 0; //left pointer
            int right = arr.length - 1; //right pointer

            while (left < right) {
                int height = Math.min(arr[left], arr[right]);
                int width = right - left;
                int currWaterContent = height * width; //area to figure out water content

                maxWater = Math.max(maxWater, currWaterContent); //updating max water content variable

                //move the pointer pointing to small value
                if (arr[left] < arr[right]) left++;
                else right--;
            }
            return maxWater;
        }
    }
}
