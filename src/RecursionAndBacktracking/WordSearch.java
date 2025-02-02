/*
https://www.geeksforgeeks.org/problems/word-search/1
You are given a two-dimensional mat[][] of size n*m containing English alphabets and a string word. Check if the word exists on the mat. The word can be constructed by using letters from adjacent cells, either horizontally or vertically. The same cell cannot be used more than once.

Examples :

Input: mat[][] = [['T', 'E', 'E'], ['S', 'G', 'K'], ['T', 'E', 'L']], word = "GEEK"
Output: true
Explanation:

The letter cells which are used to construct the "GEEK" are colored.
Input: mat[][] = [['T', 'E', 'U'], ['S', 'G', 'K'], ['T', 'E', 'L']], word = "GEEK"
Output: false
Explanation:

It is impossible to construct the string word from the mat using each cell only once.
Input: mat[][] = [['A', 'B', 'A'], ['B', 'A', 'B']], word = "AB"
Output: true
Explanation:

There are multiple ways to construct the word "AB".
Constraints:
1 ≤ n, m ≤ 6
1 ≤ L ≤ 15
mat and word consists of only lowercase and uppercase English letters.


 */
package RecursionAndBacktracking;

public class WordSearch {

    public static void main(String[] args) {
        char[][] mat = {{'T', 'E', 'E'},
                {'S', 'G', 'K'},
                {'T', 'E', 'L'}};
        String word = "ESG";
        String word2 = "TEEK";
        System.out.println(isWordExist(mat, word));
        System.out.println(isWordExist(mat, word2));

    }


    static public boolean isWordExist(char[][] mat, String word) {
        int rows = mat.length, cols = mat[0].length;
        boolean[][] visited = new boolean[rows][cols];

        // Start the search from every cell that matches the first character of the word
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == word.charAt(0)) {
                    if (isWordExist(mat, visited, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static public boolean isWordExist(char[][] mat, boolean[][] visited, String word, int currCharIdx, int row, int col) {
        if (currCharIdx == word.length()) { // All characters found
            return true;
        }

        if (!isValid(row, col, mat) || visited[row][col] || mat[row][col] != word.charAt(currCharIdx)) {
            return false;
        }

        visited[row][col] = true; // Mark current cell as visited

        // Explore in 4 directions: up, down, left, right
        boolean found = isWordExist(mat, visited, word, currCharIdx + 1, row - 1, col) || // Up
                isWordExist(mat, visited, word, currCharIdx + 1, row + 1, col) || // Down
                isWordExist(mat, visited, word, currCharIdx + 1, row, col - 1) || // Left
                isWordExist(mat, visited, word, currCharIdx + 1, row, col + 1);  // Right

        visited[row][col] = false; // Unmark for backtracking

        return found;
    }

    private static boolean isValid(int row, int col, char[][] mat) {
        return row >= 0 && row < mat.length && col >= 0 && col < mat[0].length;
    }


}
