/*

https://leetcode.com/problems/unique-paths/description/

There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.



Example 1:


Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down


Constraints:

1 <= m, n <= 100

 */
package DynamicProgramming;

import java.util.Arrays;

public class UniquePathsInGrid {

    //memoized
    public int uniquePathsMemo(int m, int n) {
        int[][] memo = new int[m][n];

        for (int row[] : memo)
            Arrays.fill(row, -1);

        return memo(m - 1, n - 1, memo);
    }
    public int memo(int i, int j, int memo[][]) {
        if (i < 0 || j < 0) return 0;
        if (i == 0 && j == 0) return 1;

        if (memo[i][j] != -1) return memo[i][j];

        return memo[i][j] = memo(i - 1, j, memo) + memo(i, j - 1, memo);
    }

    //tabulation
    public int uniquePathsTabulation(int m, int n) {
        int[][] memo = new int[m][n];

        //base case
        memo[0][0] = 1;

        //first col = 1 , beacuse reaching 0,0 to any location in first col is 1 path
        for (int i = 1; i < m; i++)
            memo[i][0] = 1;

        //first row = 1 , beacuse reaching 0,0 to any location in first row is 1 path
        for (int i = 1; i < n; i++)
            memo[0][i] = 1;

//fill remaining matrix from 1,1 to m-1,n-1(answer cell)
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
            }
        }

        return memo[m - 1][n - 1];
    }

    //space optimized tabulation

    public int uniquePaths(int m, int n) {
        int prev[] = new int[n];
        Arrays.fill(prev, 1);

        for (int i = 1; i < m; i++) {
            int curr[] = new int[n];
            curr[0] = 1;
            for (int j = 1; j < n; j++) {
                curr[j] = prev[j] + curr[j - 1];
            }

            prev = curr;
        }

        return prev[n - 1];
    }
}