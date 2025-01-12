/*

https://www.geeksforgeeks.org/problems/count-possible-triangles-1587115620/1

Given an integer array arr[]. Find the number of triangles that can be formed with three different array elements as lengths of three sides of the triangle.

A triangle with three given sides is only possible if sum of any two sides is always greater than the third side.

Examples:

Input: arr[] = [4, 6, 3, 7]
Output: 3
Explanation: There are three triangles possible [3, 4, 6], [4, 6, 7] and [3, 6, 7]. Note that [3, 4, 7] is not a possible triangle.
Input: arr[] = [10, 21, 22, 100, 101, 200, 300]
Output: 6
Explanation: There can be 6 possible triangles: [10, 21, 22], [21, 100, 101], [22, 100, 101], [10, 100, 101], [100, 101, 200] and [101, 200, 300]
Input: arr[] = [1, 2, 3]
Output: 0
Explanation: No triangles are possible.
Constraints:
3 <= arr.size() <= 103
0 <= arr[i] <= 105
 */
package TwoPointer;

import java.util.Arrays;

public class CountTriangles {
    public static void main(String[] args) {
        int[] arr = {9, 22, 15, 33, 34, 47, 7, 42, 10};
        System.out.println(new CountTriangles().new Solution().countTriangles(arr)); // Output should be 33
    }

    //T(N*N)
    class Solution {
        // Function to count the number of possible triangles.
        static int countTriangles(int[] arr) {
            int n = arr.length;
            if (n < 3) return 0; // Not enough elements to form a triangle

            // Sort the array
            Arrays.sort(arr);

            int count = 0;

            // Fix the third side and find the other two sides
            for (int k = 2; k < n; k++) {
                int i = 0;
                int j = k - 1;
                while (i < j) {
                    if (arr[i] + arr[j] > arr[k]) {
                        // All pairs (i, j) with i < j form a triangle with k
                        count += (j - i);
                        j--;
                    } else {
                        i++;
                    }
                }
            }

            return count;
        }
    }

}
