/*
Given a square matrix mat[][] of size n x n. The task is to rotate it by 90 degrees in an anti-clockwise direction without using any extra space.

Examples:

Input: mat[][] = [[1, 2, 3],
                [4, 5, 6]
                [7, 8, 9]]
Output: Rotated Matrix:
[3, 6, 9]
[2, 5, 8]
[1, 4, 7]
Input: mat[][] = [[1, 2],
                [3, 4]]
Output: Rotated Matrix:
[2, 4]
[1, 3]
Constraints:
1 ≤ n ≤ 102
0 <= mat[i][j] <= 103

*/

package Matrix;

import java.util.Arrays;

public class RotateMatrixBy90DegreeAntiClockwise {
    public static void main(String[] args) {
        int mat[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        Solution.rotateby90(mat);
        System.out.println(Arrays.deepToString(mat));
    }
}

class Solution {

    // Function to rotate matrix anticlockwise by 90 degrees.
    static void rotateby90(int mat[][]) {
        transposeMatrix(mat);
        reverseColumns(mat);
    }

    static void transposeMatrix(int mat[][]) {
        int row = mat.length;
        int col = mat[0].length;

        for (int i = 0; i < row; i++) {

            //swaping col with row val

            for (int j = i; j < col; j++) {

                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;

            }

        }
    }

    static void reverseColumns(int mat[][]) {

        for (int col = 0; col < mat.length; col++) {
            int startIdx = 0;
            int endIdx = mat.length - 1;

            while (startIdx < endIdx) {
                int temp = mat[startIdx][col];
                mat[startIdx][col] = mat[endIdx][col];
                mat[endIdx][col] = temp;
                startIdx++;
                endIdx--;
            }

        }
    }

}