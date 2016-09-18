/*
You are given coins of different denominations and a total amount of money amount. 
Write a function to compute the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.
Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.
Note:
You may assume that you have an infinite number of each kind of coin.
*/

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0) {
            return 0;
        }
         
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
         
        // initilization
        for (int i = 1; i <= amount; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k * coins[i - 1] <= j; k++) {
                    if (dp[i - 1][j - k * coins[i - 1]] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], 
                          dp[i - 1][j - k * coins[i - 1]] + k);
                    }
                }
            }
        }
         
        if (dp[n][amount] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[n][amount];
        }
    }
}

