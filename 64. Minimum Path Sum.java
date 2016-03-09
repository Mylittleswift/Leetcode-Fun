/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right 
which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/

public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[] min = new int[grid[0].length];
        //1st row
        min[0] = grid[0][0];
        for (int j = 1; j < grid[0].length; j++) {
            min[j] = min[j-1] + grid[0][j];
        }
        //2nd to last row
        for (int i = 1; i < grid.length; i++) {
            min[0] += grid[i][0];
            for (int j = 1; j < grid[0].length; j++) {
                min[j] = grid[i][j] + Math.min(min[j], min[j-1]);
            }
        }
        return min[grid[0].length - 1];
    }
}


