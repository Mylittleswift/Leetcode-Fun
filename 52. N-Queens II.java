/*
Follow up for N-Queens problem.
Now, instead outputting board configurations, return the total number of distinct solutions.
*/

public class Solution {
    private int result = 0;
    public int totalNQueens(int n) {
        if (n == 0 || n == 2 || n == 3) {
            return 0;
        }
        int[] cols = new int[n];
        totalNQueensHelper(n, 0, cols);
         
        return result;
    }
     
    private void totalNQueensHelper(int n, int row, int[] cols) {
        if (row == n) {
            result++;
            return;
        }
         
        for (int j = 0; j < n; j++) {
            if (isValid(j, row, cols)) {
                cols[row] = j; 
                totalNQueensHelper(n, row + 1, cols);
            }
        }
    }
     
    private boolean isValid(int col, int rows, int[] cols) {
        for (int i = 0; i < rows; i++) {
            if (cols[i] == col || rows - i == Math.abs(cols[i] - col)) {
                return false;
            }
        }
        return true;
    }
}

