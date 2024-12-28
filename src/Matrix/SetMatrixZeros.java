/*
You are given a 2D matrix mat[][] of size n×m. The task is to modify the matrix such that if mat[i][j] is 0, all the elements in the i-th row and j-th column are set to 0 and do it in constant space complexity.

Examples:

Input: mat[][] = [[1, -1, 1],
                [-1, 0, 1],
                [1, -1, 1]]
Output: [[1, 0, 1],
        [0, 0, 0],
        [1, 0, 1]]
Explanation: mat[1][1] = 0, so all elements in row 1 and column 1 are updated to zeroes.
Input: mat[][] = [[0, 1, 2, 0],
                [3, 4, 5, 2],
                [1, 3, 1, 5]]
Output: [[0, 0, 0, 0],
        [0, 4, 5, 0],
        [0, 3, 1, 0]]
Explanation: mat[0][0] and mat[0][3] are 0s, so all elements in row 0, column 0 and column 3 are updated to zeroes.
Constraints:
1 ≤ n, m ≤ 500
- 231 ≤ mat[i][j] ≤ 231 - 1


 */

package Matrix;

import java.util.Arrays;

public class SetMatrixZeros {
    public static void main(String[] args) {
        int mat[][] = {{8, 1, 2, 8},
                {3, 4, 0, 2},
                {1, 3, 1, 5}};

        Solution obj = new SetMatrixZeros().new Solution();
        obj.setMatrixZeroes(mat);
        System.out.println(Arrays.deepToString(mat));

    }

    class Solution {
        public void setMatrixZeroes(int[][] mat) {

            boolean isStartingRowZero = false;
            boolean isStartingColZero = false;

            //check if starting row contains zero
            for (int i = 0; i < mat[0].length; i++)
                if (mat[0][i] == 0) {
                    isStartingRowZero = true;
                    break;
                }

            //check if starting col contains zero
            for (int j = 0; j < mat.length; j++) {
                if (mat[j][0] == 0) {
                    isStartingColZero = true;
                    break;
                }
            }

            //marking 0th col and 0th row of any cell which has zero
            for (int i = 1; i < mat.length; i++) {
                for (int j = 1; j < mat[i].length; j++) {
                    if (mat[i][j] == 0) { //marking col/row as zero at 0th indexes
                        mat[0][j] = 0;
                        mat[i][0] = 0;
                    }
                }
            }
            //marking every row and col zero if it has 0th col and 0th row cell zero
            for (int i = 1; i < mat.length; i++) {
                for (int j = 1; j < mat[i].length; j++) {
                    if (mat[i][0] == 0 || mat[0][j] == 0) { //for curr cell i,j row and col cell has zero.
                        mat[i][j] = 0;
                    }
                }
            }

            //making 0th row and 0th col zero
            if (isStartingRowZero) {
                Arrays.fill(mat[0], 0);
            }
            if (isStartingColZero) {
                for (int i = 0; i < mat.length; i++)
                    mat[i][0] = 0;
            }
        }
    }

}


