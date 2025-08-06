package Graph;
/*
https://leetcode.com/problems/number-of-islands/description/
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.



Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
 */
public class NumberOfIsland {

    //T(row * col) S(row * col)
    class Solution {
        public int numIslands(char[][] grid) {
            int count = 0;
            //check whichever cell can be starting cell , try island beginning from all possible starting cell
            for (int i = 0; i<grid.length; i++) {
                for (int j = 0; j<grid[i].length; j++) {
                    if (grid[i][j] == '1') { //if land exist only then start from here
                        dfs(grid,i,j);
                        count++;
                    }
                }
            }
            return count;
        }

        public void dfs(char[][] grid, int i,int j){

            int row = grid.length;
            int col = grid[0].length;

            if(i>=row || j>=col || i<0 || j<0) return; //invalid out of boundry

            if(grid[i][j]=='0') return; // cant visit it's water

            if(grid[i][j]=='2') return; //already visited

            //visit all direction(hori/vertically not diagonally) and mark curr cell visited
            grid[i][j]='2';

            dfs(grid,i+1,j);
            dfs(grid,i,j+1);
            dfs(grid,i-1,j);
            dfs(grid,i,j-1);
        }
    }
}
