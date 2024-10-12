/*
https://leetcode.com/problems/rotting-oranges/description/

You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Example 1:

Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.


 */

package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static void main(String[] args) {
        int[][] grid1 = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int[][] grid2 = {{2,1,1},{0,1,1},{1,0,1}};
        int[][] grid3 = {{0,2}};

        Solution obj = new RottenOranges().new Solution();
        System.out.println("total time is : "+obj.orangesRotting(grid1)+" to rotten the oranges");
        System.out.println("total time is : "+obj.orangesRotting(grid2)+" to rotten the oranges");
        System.out.println("total time is : "+obj.orangesRotting(grid3)+" to rotten the oranges");

    }

    class Orange {

        int row;
        int col;
        int time; //time when it will be rotten

        public Orange(int _row, int _col, int _time) {
            this.row = _row;
            this.col = _col;
            this.time = _time;
        }

    }

    class Solution {
        // T(Row * Col) , S(Row * Col)
        public int orangesRotting(int[][] grid) {

            Queue<Orange> queue = new LinkedList<>();

            int[][] visited = new int[grid.length][grid[0].length];

            int maxTime = 0;

            int unRottenOranges = 0; //count of total unrotten oranges

            //insert all rotten oranges in queue, with time =0 since it is initial time and they are already rotten
            //and dont deserve to be rotten

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 2) {
                        queue.add(new Orange(i, j, 0));
                        visited[i][j] = 2;
                    } else {
                        visited[i][j] = 0;
                        if (grid[i][j] == 1) { //unrotten
                            unRottenOranges++;
                        }
                    }
                }
            }

            while (!queue.isEmpty()) {
                int row = queue.peek().row;
                int col = queue.peek().col;
                int currTime = queue.peek().time;
                queue.poll();

                maxTime = Math.max(maxTime, currTime);
                //explorer upward    row-1 , col
                int newRow = row - 1, newCol = col;
                if (isValid(grid, newRow, newCol) && grid[newRow][newCol] != 0 && visited[newRow][newCol] != 2) { //check if its valid and not visited and not empty i.e 0
                    queue.add(new Orange(newRow, newCol, currTime + 1));
                    visited[newRow][newCol] = 2;
                    unRottenOranges--; //reduce unRottenOranges as we have just rotten one orange
                }

                //explorere downward row+1 , col
                newRow = row + 1;
                newCol = col;
                if (isValid(grid, newRow, newCol) && grid[newRow][newCol] != 0 && visited[newRow][newCol] != 2) { //check if its valid and not visited and not empty i.e 0
                    queue.add(new Orange(newRow, newCol, currTime + 1));
                    visited[newRow][newCol] = 2;
                    unRottenOranges--; //reduce unRottenOranges as we have just rotten one orange
                }

                //explore left row,col-1
                newRow = row;
                newCol = col - 1;
                if (isValid(grid, newRow, newCol) && grid[newRow][newCol] != 0 && visited[newRow][newCol] != 2) { //check if its valid and not visited and not empty i.e 0
                    queue.add(new Orange(newRow, newCol, currTime + 1));
                    visited[newRow][newCol] = 2;
                    unRottenOranges--; //reduce unRottenOranges as we have just rotten one orange
                }

                //explore right row, col+1
                newRow = row;
                newCol = col + 1;
                if (isValid(grid, newRow, newCol) && grid[newRow][newCol] != 0 && visited[newRow][newCol] != 2) { //check if its valid and not visited and not empty i.e 0
                    queue.add(new Orange(newRow, newCol, currTime + 1));
                    visited[newRow][newCol] = 2;
                    unRottenOranges--; //reduce unRottenOranges as we have just rotten one orange
                }
            }


    /*

    //check if all oranges grid[][] are rotten or not
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1 && visited[i][j]!=2){
                   return -1; //since grid has non-rotten orange but it is not rotten
                }
            }
        }

        return maxTime;
        */
            if (unRottenOranges == 0) return maxTime; //if unrotten oranges are 0 , we return maximum time it took
            else return -1; // minus one otherwise.
        }

        boolean isValid(int[][] grid, int row, int col) {
            return (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length);
        }

    }
}
