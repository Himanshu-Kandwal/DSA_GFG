package DynamicProgramming;

import java.util.Arrays;

/*
https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/
Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).



Example 1:


Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:


Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
Example 3:

Input: matrix = [[1]]
Output: 1


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 200
0 <= matrix[i][j] <= 231 - 1

 */
public class LongestIncreasingPathInMatrix {
    class Solution {
        public int longestIncreasingPath(int[][] matrix) {
            int[][] dp = new int[matrix.length][matrix[0].length];
            for (int row[] : dp)
                Arrays.fill(row, -1);

            int ans=0;

            for(int i=0;i<matrix.length;i++){
                for(int j=0; j<matrix[i].length;j++){
                    int curr = dfs(matrix,dp,i,j,-1); //for first cell of path prevVal will not exist so its -1
                    ans = Math.max (ans,curr);

                }
            }

            return ans;
        }

        public int dfs(int[][] matrix, int[][] dp, int row, int col, int preVal) {
            //boundry base case
            if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length)
                return 0;
            //if curr cell is less or equal then prev cell from where we came , return 0 as can not go further
            if (matrix[row][col] <= preVal)
                return 0;

            //if alredy computed
            if (dp[row][col] != -1)
                return dp[row][col];

            //default lenghth of path is 1 as the cell itself is one point of path if no other cells fall in path
            int res = 1;
            //explore all horizontal and verticle directions not diagonal
            res = Math.max(res, 1+ dfs(matrix, dp, row, col+1, matrix[row][col]));
            res = Math.max(res, 1+ dfs(matrix, dp, row+1, col, matrix[row][col]));
            res = Math.max(res, 1+ dfs(matrix, dp, row-1, col, matrix[row][col]));
            res = Math.max(res, 1+ dfs(matrix, dp, row, col-1, matrix[row][col]));

            dp[row][col] = res;
            return res;

        }
    }
}
