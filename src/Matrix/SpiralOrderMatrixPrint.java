package Matrix;

public class SpiralOrderMatrixPrint {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        };

        int top = 0;
        int right = matrix[0].length - 1; // fixed minus sign
        int bottom = matrix.length - 1;   // fixed minus sign
        int left = 0;

        while (top <= bottom && left <= right) {

            // Traverse Right
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + ", ");
            }
            top++;

            // Traverse Down
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + ", ");
            }
            right--;

            // Traverse Left (Guard check required for non-square matrices so we have a row to traverse and not duplicate)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix[bottom][i] + ", ");
                }
                bottom--;
            }

            // Traverse Up (Guard check required for non-square matrices, so we have a column and not printing duplicate)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + ", ");
                }
                left++;
            }
        }
    }
}