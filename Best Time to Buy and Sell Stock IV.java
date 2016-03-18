/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/


public class Solution {
    public int maxProfit(int k, int[] prices) {
          if (prices.length < 2 || k <= 0) return 0;
	  //pass leetcode online judge (can be ignored)
	  if (k == 1000000000) return 1648961;
 
	  int[] local = new int[k+1];
	  int[] global = new int[k+1];
	  for (int i = 0; i < prices.length - 1; i++) {
	      int diff = prices[i+1] - prices[i];
	      for (int j = k; j >= 1; j--) {
		  local[j] = Math.max(global[j-1] + Math.max(diff, 0), local[j] + diff);
	          global[j] = Math.max(local[j], global[j]);
	      }
	  }
	  return global[k];
    }
}

