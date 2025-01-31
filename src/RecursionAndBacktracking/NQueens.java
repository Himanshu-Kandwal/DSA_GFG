package RecursionAndBacktracking;

import java.util.ArrayList;

public class NQueens {
    public static void main(String[] args) {
        System.out.println(new NQueens().nQueen(5));
    }

    public ArrayList<ArrayList<Integer>> nQueen(int N) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        nQueen(N, 0, new int[N][N], new ArrayList<>(), result);
        return result;
    }

    public void nQueen(int N, int currRow, int[][] board, ArrayList<Integer> currConfig, ArrayList<ArrayList<Integer>> result) {
        //placed all queens so add curr config to result
        if (currConfig.size() == N) {
            result.add(new ArrayList<>(currConfig));
            return; //terminate
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(board, currRow, col)) {
                //put queen in the board
                board[currRow][col] = 1;
                //add queen to current config
                currConfig.add(col + 1); //1-based indexing

                //put queen in next row
                nQueen(N, currRow + 1, board, currConfig, result);

                board[currRow][col] = 0; //removing queen for backtracking
                currConfig.remove(currConfig.size() - 1); //removing last value from current config for backtracking
            }
        }
    }


//check if column does not have queen, we don't need to check for rows because we place 1 queen in a row and move to next row
//so automatically 1 row has 1 queen only , no double queen in same row

    boolean isSafe(int[][] board, int r, int c) {
        final int len = board.length;

        // Check vertical column for a queen
        for (int i = 0; i < r; i++) {
            if (board[i][c] == 1) return false;
        }

        // Check diagonal '/' (upper right)
        for (int row = r, col = c; row >= 0 && col < len; row--, col++) {
            if (board[row][col] == 1) return false;
        }

        // Check diagonal '\' (upper left)
        for (int row = r, col = c; row >= 0 && col >= 0; row--, col--) {
            if (board[row][col] == 1) return false;
        }

        return true; // No conflicts found
    }

}
