/*
Given a row-wise sorted 2D matrix mat[][] of size n x m and an integer x, find whether element x is present in the matrix.
Note: In a row-wise sorted matrix, each row is sorted in itself, i.e. for any i, j within bounds, mat[i][j] <= mat[i][j+1].

Examples :

Input: mat[][] = [[3, 4, 9],[2, 5, 6],[9, 25, 27]], x = 9
Output: true
Explanation: 9 is present in the matrix, so the output is true.
Input: mat[][] = [[19, 22, 27, 38, 55, 67]], x = 56
Output: false
Explanation: 56 is not present in the matrix, so the output is false.
Input: mat[][] = [[1, 2, 9],[65, 69, 75]], x = 91
Output: false
Explanation: 91 is not present in the matrix.
Constraints:
1 <= n, m <= 1000
1 <= mat[i][j] <= 105
1 <= x <= 105


 */
package Matrix;

public class SearchInRowWiseSortedMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 5}, {6, 9, 10}, {0, 10, 28}};
        System.out.println(new SearchInRowWiseSortedMatrix().new Solution().searchRowMatrix(mat, 10));
    }

    //Worst case T(N * Log M) N=rows, M=col , since we are first iterating through N rows to find which row possibly contain X,
    //and then doing binary search in that row.
    class Solution {
        // Function to search a given number in row-column sorted matrix.
        public boolean searchRowMatrix(int[][] mat, int x) {

            for (int row[] : mat) {
                if ((x >= row[0] && x <= row[row.length - 1]) && search(row, x)) {
                    return true;
                }
            }
            return false;
        }

        public boolean search(int arr[], int x) {
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
