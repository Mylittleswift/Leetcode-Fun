/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int re=n-1,rs=0,ce=n-1,cs=0;
        int c=1;
        while (cs<ce){
            //right
            for (int i=cs; i<=ce; i++){
                res[rs][i] = c;
                c++;
            }
            rs++;
            //down
            for (int i=rs; i<=re; i++){
                res[i][ce] = c;
                c++;
            }
            ce--;
            //left
            for (int i=ce; i>=cs; i--){
                res[re][i] = c;
                c++;
            }
            re--;
            //up
            for (int i=re; i>=rs; i--){
                res[i][cs] = c;
                c++;
            }
            cs++;
        }
        //n odd
        if (cs==ce){ //the start and end counter meets
            res[rs][cs] = n*n;
        }
        return res;
    }
}

