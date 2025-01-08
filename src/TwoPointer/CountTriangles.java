package TwoPointer;

import java.util.Arrays;

public class CountTriangles {

    class Solution {
        // Function to count the number of possible triangles.
        static int countTriangles(int arr[]) {
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
