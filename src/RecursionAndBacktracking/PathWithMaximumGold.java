package RecursionAndBacktracking;

/*
https://leetcode.com/problems/path-with-maximum-gold/description/

In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.

Return the maximum amount of gold you can collect under the conditions:

Every time you are located in a cell you will collect all the gold in that cell.
From your position, you can walk one step to the left, right, up, or down.
You can't visit the same cell more than once.
Never visit a cell with 0 gold.
You can start and stop collecting gold from any position in the grid that has some gold.


Example 1:

Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
Output: 24
Explanation:
[[0,6,0],
 [5,8,7],
 [0,9,0]]
Path to get the maximum gold, 9 -> 8 -> 7.
Example 2:

Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
Output: 28
Explanation:
[[1,0,7],
 [2,0,6],
 [3,4,5],
 [0,3,0],
 [9,0,20]]
Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 15
0 <= grid[i][j] <= 100
There are at most 25 cells containing gold.

 */

//without visited matrix
class PathWithMaximumGold {

    public int getMaximumGold(int[][] grid) {
        //boolean visited[][] = new boolean[grid.length][grid[0].length];

        int max = 0;

        //we can start from any cell which is not 0, so we are starting from all cell and getting max
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    int currGold = getMaximumGold(i, j, grid);
                    max = Math.max(max, currGold);
                }
            }
        }

        return max;
    }

    public int getMaximumGold(int r, int c, int[][] grid) {
        int m = grid.length - 1; //last row idx
        int n = grid[0].length - 1; //last col idx

        //check if cell is valid i.e not out of boundry, not 0 gold cell, not already visited cell i.e 0 value cell
        if (r < 0 || c < 0 || r > m || c > n || grid[r][c] == 0)
            return 0;

        //storing curr gold  before marking visited
        int currGold = grid[r][c];

        //mark curr cell as visited (invalid for next move)
        grid[r][c] = 0;

        //exploring gold from all direction
        //top
        int topGold = getMaximumGold(r - 1, c, grid);
        //bottom
        int bottomGold = getMaximumGold(r + 1, c, grid);

        //left
        int leftGold = getMaximumGold(r, c - 1, grid);

        //right
        int rightGold = getMaximumGold(r, c + 1, grid);

        grid[r][c] = currGold; // marking unVisited by restoring value to original value, so other recursive calls can also explore the cell

        int maxLR = Math.max(leftGold, rightGold);
        int maxTB = Math.max(topGold, bottomGold);

        return currGold + Math.max(maxLR, maxTB);

    }
}

/*
using visited matrix's extra space
class Solution {
    public int getMaximumGold(int[][] grid) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];

        int max = 0;

        //we can start from any cell which is not 0, so we are starting from all cell and getting max
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    int currGold = getMaximumGold(i, j, grid, visited);
                    max = Math.max(max, currGold);
                }
            }
        }

        return max;
    }

    public int getMaximumGold(int r, int c, int[][] grid, boolean visited[][]) {
        int m = grid.length - 1; //last row idx
        int n = grid[0].length - 1; //last col idx

        //check if cell is valid i.e not out of boundry, not 0 gold cell, not already visited cell
        if (r < 0 || c < 0 || r > m || c > n || grid[r][c] == 0 || visited[r][c])
            return 0;
        //mark curr cell as visited
        visited[r][c] = true;

        //exploring gold from all direction
        int currGold = grid[r][c];
        //top
        int topGold = getMaximumGold(r - 1, c, grid, visited);
        //bottom
        int bottomGold = getMaximumGold(r + 1, c, grid, visited);

        //left
        int leftGold = getMaximumGold(r, c - 1, grid, visited);

        //right
        int rightGold = getMaximumGold(r, c + 1, grid, visited);

        visited[r][c] = false; // marking visited false, so other recursive calls can also explore the cell

        int maxLR = Math.max(leftGold, rightGold);
        int maxTB = Math.max(topGold, bottomGold);

        return currGold + Math.max(maxLR, maxTB);

    }
}
*/
