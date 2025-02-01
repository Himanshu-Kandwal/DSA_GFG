package RecursionAndBacktracking;

import java.util.Arrays;

public class SolveSudoku {

    public static void main(String[] args) {
        int SIZE = 9;

        int[][] board = new int[SIZE][SIZE];
        board[0][0] = 5;
        System.out.println("before solving");
        printBoard(board);
        solveSudoku(board);
        System.out.println("after solving");
        printBoard(board);
    }

    private static void printBoard(int[][] board) {
        for (int[] row : board)
            System.out.println(Arrays.toString(row));
    }

    static void solveSudoku(int[][] board) {
        int SIZE = board.length;
        // Tracking arrays to quickly check if curr row, col or subgrid has number already present or not
        boolean[][] row = new boolean[SIZE][SIZE + 1]; // row[rIdx][value] == true/false means at current row, the value is present
        boolean[][] col = new boolean[SIZE][SIZE + 1]; // '' '' ''       ''                 ''                  ''         ''
        boolean[][][] subGrid = new boolean[3][3][SIZE + 1]; // subgrid[rowIdx/3][colIdx/3][value] ==true/false means among 9 subgrid of 3X3 inside 9X9 grid value is present in subgrid[row/3][col/3]


        //sudoku may have some cells filled in the board by default, mark them in our visited arrays by initializing

        // Initialize tracking arrays based on the pre-filled values
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                int value = board[r][c];
                if (value != 0) { //if curr cell is not empty , mark the value in row/col/subgrid array
                    row[r][value] = true;
                    col[c][value] = true;
                    subGrid[r / 3][c / 3][value] = true;
                }
            }
        }

        int rowIdx = 0;
        int colIdx = 0;
        helperSudoku(rowIdx, colIdx, board, row, col, subGrid);
    }

    private static boolean helperSudoku(int rowIdx, int colIdx, int[][] board, boolean[][] row, boolean[][] col, boolean[][][] subGrid) {

        final int SIZE = board.length;
        if (rowIdx == SIZE) { //
            return true; //filled 0..len-1 rows, and now out of boundary, so returning true as we solved it
        }
        //if colIdx has reached beyond end col, we run recursion for next row i.e rowIdx+1 and col=0th;
        if (colIdx == SIZE) {
            return helperSudoku(rowIdx + 1, 0, board, row, col, subGrid);
        }

        //curr cell is already filled, so run sudoku solver on it, rather going below and checking nums from 1-9 on it
        if (board[rowIdx][colIdx] != 0) {
            return helperSudoku(rowIdx, colIdx + 1, board, row, col, subGrid);
        }

        for (int value = 1; value <= SIZE; value++) {
                if (isValidPosition(value, rowIdx, colIdx, row, col, subGrid)) {
                    //set curr cell value
                    board[rowIdx][colIdx] = value;
                    //marking row,col,subgrid that we have used a value
                    row[rowIdx][value] = col[colIdx][value] = subGrid[rowIdx / 3][colIdx / 3][value] = true;

                    //check for further if they can be filled
                    if (helperSudoku(rowIdx, colIdx + 1, board, row, col, subGrid)) {
                        return true;
                    }

                    //since above if condition failed i.e no correct sudoku solution found, to backtrack we will unset the cell
                    //and unMark row col and subgrid
                    //un-set curr cell value
                    board[rowIdx][colIdx] = 0;
                    //un-marking row,col,subgrid that we have not used a value
                    row[rowIdx][value] = col[colIdx][value] = subGrid[rowIdx / 3][colIdx / 3][value] = false;

                }
        }
        return false;
    }

    static boolean isValidPosition(int value, int row, int col, boolean[][] rowVisited, boolean[][] colVisited, boolean[][][] subgridVisited) {
        if (rowVisited[row][value]) return false; //the value exist in current row
        if (colVisited[col][value]) return false; // the value exist in current col
        if (subgridVisited[row / 3][col / 3][value]) return false; // the value exist in current subgrid
        return true;
    }
}
