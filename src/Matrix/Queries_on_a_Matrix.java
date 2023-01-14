package Matrix;

import java.util.Arrays;

/*
https://practice.geeksforgeeks.org/problems/queries-on-a-matrix0443/1

Queries on a Matrix
Hard
Accuracy: 78.65% Submissions: 1941Points: 8
You are given a matrix of dimension n*n. All the cells are initially, zero. You are given Q queries, which contains 4 integers a b c d where (a,b) is the TOP LEFT cell and (c,d) is the Bottom Right cell of a submatrix. Now, all the cells of this submatrix have to be incremented by one. After all the Q queries have been performed. Your task is to find the final resulting Matrix.
Note : Zero-Based Indexing is used for cells of the matrix.


Example 1:

Input: n = 6, q = 6,
Queries = {
{4,0,5,3},
{0,0,3,4},
{1,2,1,2},
{1,1,2,3},
{0,0,3,1},
{1,0,2,4}}.
Output:
2 2 1 1 1 0
3 4 4 3 2 0
3 4 3 3 2 0
2 2 1 1 1 0
1 1 1 1 0 0
1 1 1 1 0 0
Explanation:After incrementing all the
sub-matrices of given queries we will
get the final output.





Example 2:

Input: n = 4, q = 2,
Queries = {
{0,0,3,3},
{0,0,2,2}}.
Output:
2 2 2 1
2 2 2 1
2 2 2 1
1 1 1 1
Explanation:After incrementing all the
sub-matrices of given queries we will
get the final output.
Your Task:
You don't need to read or print anything. Your task is to complete the function solveQueries() which takes n and Queries and input parameter and returns a matrix after performing all the queries.


Expected Time Complexity: O(n2)
Expected Space Complexity: O(n2)


Constraints:
1 <= n <= 1000
0 <= a <= c < n
0 <= b <= d < n
1 <= No. of Queries <= 1000


 */
public class Queries_on_a_Matrix {
    public static void main(String[] args) {
        int queries[][] = {
                {4, 0, 5, 3},
                {0, 0, 3, 4},
                {1, 2, 1, 2},
                {1, 1, 2, 3},
                {0, 0, 3, 1},
                {1, 0, 2, 4}};
        int n = 6; //the size of querys n*n matrix
        System.out.println(Arrays.deepToString(solveQueries(n, queries)));

    }

    public static int[][] solveQueries(int n, int[][] Queries) {

        int matrix[][] = new int[n][n];

        //filling all rows with 0 of an array
        for (int row[] : matrix)
            Arrays.fill(row, 0);
        //runQueries(matrix, Queries);
        runQueriesOptimized(matrix, Queries);
        return matrix;
    }

    //O(n^3) S(N^2); bruteforce
    public static void runQueries(int[][] matrix, int[][] Queries) {
        for (int row[] : Queries) //fetching query row by row
        {
            //fetching values a,b,c,d
            int a = row[0];
            int b = row[1];
            int c = row[2];
            int d = row[3];
            //since a,b is top left cell and cd is bottom right cell
            int sRow = a;
            int eRow = c;
            int sCol = b;
            int eCol = d;

            for (int i = sRow; i <= eRow; i++) {
                for (int j = sCol; j <= eCol; j++) {
                    matrix[i][j] = matrix[i][j] + 1;
                }
            }
        }
    }

    //O(n^2) s(n^2)
    public static void runQueriesOptimized(int[][] matrix, int[][] Queries) {
        for (int row[] : Queries) //fetching query row by row
        {
            //fetching values a,b,c,d
            int a = row[0];
            int b = row[1];
            int c = row[2];
            int d = row[3];
            //since a,b is top left cell and cd is bottom right cell
            int sRow = a;
            int eRow = c;
            int sCol = b;
            int eCol = d;

            //incr coloumn
            for (int i = sRow; i <= eRow; i++) {
                matrix[i][sCol]++;
                if (eCol < matrix.length - 1) matrix[i][eCol + 1]--;
            }

            for (int col = 1; col < matrix.length; col++) {
                for (int currRow = 0; currRow < matrix.length; currRow++) {
                    matrix[currRow][col] += matrix[currRow][col - 1];
                }
            }
        }
    }
}
