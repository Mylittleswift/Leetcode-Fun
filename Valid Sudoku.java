 /**
 *https://leetcode.com/problems/valid-sudoku/
 */
 
 
 public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // horizontal
        for (int i = 0; i < 9; i++) {
            boolean[] exist = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if (exist[board[i][j] - '1']) {
                        return false;
                    }
                    exist[board[i][j] - '1'] = true;
                }
            }
        }
        // vertical 
        for (int j = 0; j < 9; j++) {
            boolean[] exist = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if(board[i][j] != '.') {
                    if (exist[board[i][j] - '1']) {
                        return false;
                    }
                    exist[board[i][j] - '1'] = true;
                }
            }
        }
        // box
        for (int m = 0; m < 3; m++) {
            for (int n =  0; n < 3; n++) {
                boolean[] exist = new boolean[9];
                for (int k = 0; k < 9; k++) {
                    if(board[3 * m + k / 3][3 * n + k % 3] != '.') {
                        if (exist[board[3 * m + k / 3][3 * n + k % 3] - '1']) {
                            return false;
                        }
                        exist[board[3 * m + k / 3][3 * n + k % 3] - '1'] = true;
                    }
                }
            }
        }
        return true;
    }
}

