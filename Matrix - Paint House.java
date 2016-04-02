/*
There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. 
The cost of painting each house with a certain color is different. 
You have to paint all the houses such that no two adjacent houses have the same color.
The cost of painting each house with a certain color is represented by a n x 3 cost matrix. 
For example, costs[0][0] is the cost of painting house 0 with color red; 
costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
Note:
All costs are positive integers.
*/

//dynamic programming
public class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
         
        int[][] dp = new int[costs.length][3];
         
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
         
        for (int i = 1; i < costs.length; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
         
        return Math.min(dp[costs.length - 1][0], Math.min(dp[costs.length - 1][1], dp[costs.length - 1][2]));
    }
}


//constant space
public class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
         
        int n = costs.length;
        int[] prev = new int[3];
        int[] curr = new int[3];
         
        prev[0] = costs[0][0];
        prev[1] = costs[0][1];
        prev[2] = costs[0][2];
         
        for (int i = 1; i < n; i++) {
            curr[0] = Math.min(prev[1], prev[2]) + costs[i][0];
            curr[1] = Math.min(prev[0], prev[2]) + costs[i][1];
            curr[2] = Math.min(prev[0], prev[1]) + costs[i][2];
             
            // update the curr
            prev[0] = curr[0];
            prev[1] = curr[1];
            prev[2] = curr[2];
        }
         
        return Math.min(Math.min(prev[0], prev[1]), prev[2]);
    }
}


