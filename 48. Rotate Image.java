/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/

public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int round = 0; round < n/2; round++) {
            //the start and end of the new round (circle)
            int start = round;
            int end = n-round-1;
            //the last element for each row/col does not need to be swapped, so "<"
            for (int i = 0; i < end-start; i++){
                //store top row value as temp
                int temp = matrix[start][start+i];
                //leftmost col -> top row
                matrix[start][start+i] = matrix[end-i][start];
                //bottom row -> leftmost col
                matrix[end-i][start] = matrix[end][end-i];
                //rightmost col -> bottom row
                matrix[end][end-i] =  matrix[start+i][end];
                //top row -> rightmost col
                matrix[start+i][end] = temp;
            }
        }
        
    }
}

