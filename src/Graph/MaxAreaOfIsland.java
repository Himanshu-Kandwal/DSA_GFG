package Graph;
/*

https://leetcode.com/problems/max-area-of-island/description/

You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 on the island.

Return the maximum area of an island in grid. If there is no island, return 0.

Example 1:

Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] is either 0 or 1.

 */
public class MaxAreaOfIsland {

    //T(M x N) , S(M x N)
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            //check whichever cell can be starting cell , try island beginning from all possible starting cell
            int maxArea = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) { //if land exist only then start from here
                        int curr = dfs(grid, i, j);
                        maxArea = Math.max(maxArea, curr);
                    }
                }
            }
            return maxArea;
        }

        public int dfs(int[][] grid, int i, int j) {

            int row = grid.length;
            int col = grid[0].length;

            if (i >= row || j >= col || i < 0 || j < 0)
                return 0; //invalid out of boundry

            if (grid[i][j] == 0)
                return 0; // cant visit it's water

            if (grid[i][j] == 2)
                return 0; //already visited

            //visit all direction(hori/vertically not diagonally) and mark curr cell visited
            grid[i][j] = 2;

            int area1 = dfs(grid, i + 1, j);
            int area2 = dfs(grid, i, j + 1);
            int area3 = dfs(grid, i - 1, j);
            int area4 = dfs(grid, i, j - 1);

            return 1 + area1 + area2 + area3 + area4; // 1 added for curr cell and remaining area of all directions added

        }
    }
}
