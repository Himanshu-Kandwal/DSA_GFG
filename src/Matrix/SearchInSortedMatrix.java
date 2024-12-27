/*
https://www.geeksforgeeks.org/batch/gfg-160-problems/track/matrix-gfg-160/problem/search-in-a-matrix-1587115621

Given a strictly sorted 2D matrix mat[][] of size n x m and a number x. Find whether the number x is present in the matrix or not.
Note: In a strictly sorted matrix, each row is sorted in strictly increasing order, and the first element of the ith row (i!=0) is greater than the last element of the (i-1)th row.

Examples:

Input: mat[][] = [[1, 5, 9], [14, 20, 21], [30, 34, 43]], x = 14
Output: true
Explanation: 14 is present in the matrix, so output is true.
Input: mat[][] = [[1, 5, 9, 11], [14, 20, 21, 26], [30, 34, 43, 50]], x = 42
Output: false
Explanation: 42 is not present in the matrix.
Input: mat[][] = [[87, 96, 99], [101, 103, 111]], x = 101
Output: true
Explanation: 101 is present in the matrix.
Constraints:
1 <= n, m <= 1000
1 <= mat[i][j] <= 109
1 <= x <= 109


 */

package Matrix;

public class SearchInSortedMatrix {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 5, 9},
                {14, 20, 21},
                {30, 34, 43}
        };

        // Value to search for
        int x = 20;

        System.out.println(new SearchInSortedMatrix().new Solution().searchMatrix(mat,x));
    }

    class Solution {

        //T(log n*m)
        // Function to search a given number in row-column sorted matrix.
        public boolean searchMatrix(int[][] mat, int x) {
            int rowStart = 0;
            int rowEnd = mat.length-1;

            //check if x even falls inside matrix or not
            if(x<mat[0][0] || x> mat[rowEnd][mat[rowEnd].length-1]){
                return false;
            }


            while (rowStart <= rowEnd) {
                int midRow = rowStart + (rowEnd - rowStart) / 2;
                int colLen = mat[midRow].length;

                //check if we can find X in mid row
                if (x >= mat[midRow][0] && x <= mat[midRow][colLen - 1]) {
                    //search X in curr/mid row using binary search
                    return search(mat[midRow], x);
                }

                if (x < mat[midRow][0]) { //check if X could lie before mid row, if yes run current loop for top half of matrix
                    rowEnd = midRow-1;
                }

                if (x > mat[midRow][0]) {// check if X lie after mid, it may lie after mid row, so run current loop for bottom half of matrix
                    rowStart = midRow+1;
                }
            }
            return false;
        }

        private boolean search(int arr[], int x) {
            int l = 0;
            int r = arr.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;

                if (x == arr[mid]) return true;

                if (x < arr[mid]) r = mid - 1;
                else l = mid + 1;
            }

            return false;
        }
    }
}

