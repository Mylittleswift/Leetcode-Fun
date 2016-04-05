/*
According to the Wikipedia's article: "The Game of Life, also known simply as Life, 
is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). 
Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules 
(taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.

Follow up: 
Could you solve it in-place? Remember that the board needs to be updated at the same time: 
You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, 
which would cause problems when the active area encroaches the border of the array. How would you address these problems?
*/

public class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        // If live to dead, mark 2
        // If dead to live, mark 3
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = getNumLiveNeighbors(i, j, board);
                 
                if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = 2;
                    }
                } else {
                    if (liveNeighbors == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }
         
        // Step 2: loop-over the board again and mark 2 as 0 and 3 as 1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
     
    private int getNumLiveNeighbors(int row, int col, int[][] board) {
        int result = 0;
         
        int m = board.length;
        int n = board[0].length;
         
        // Up
        if (row - 1 >= 0 && (board[row - 1][col] == 1 || board[row - 1][col] == 2)) {
            result += 1;
        }
         
        // Down
        if (row + 1 < m && (board[row + 1][col] == 1 || board[row + 1][col] == 2)) {
            result += 1;
        }
         
        // Left
        if (col - 1 >= 0 && (board[row][col - 1] == 1 || board[row][col - 1] == 2)) {
            result += 1;
        }
         
        // Right
        if (col + 1 < n && (board[row][col + 1] == 1 || board[row][col + 1] == 2)) {
            result += 1;
        }
         
        // NW
        if (row - 1 >= 0 && col - 1 >= 0 && (board[row - 1][col - 1] == 1 || board[row - 1][col - 1] == 2)) {
            result += 1;
        }
         
        // NE
        if (row - 1 >= 0 && col + 1 < n && (board[row - 1][col + 1] == 1 || board[row - 1][col + 1] == 2)) {
            result += 1;
        }
         
        // SW
        if (row + 1 < m && col - 1 >= 0 && (board[row + 1][col - 1] == 1 || board[row + 1][col - 1] == 2)) {
            result += 1;
        }
         
        // SE
        if (row + 1 < m && col + 1 < n && (board[row + 1][col + 1] == 1 || board[row + 1][col + 1] == 2)) {
            result += 1;
        }
         
        return result;
    }
}

