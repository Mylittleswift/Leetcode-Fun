 /**
  *You are climbing a stair case. It takes n steps to reach to the top.
  *Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
  */
  
  
  public class Solution {
    public int climbStairs(int n) {
		if (n == 0 || n == 1)
			return n;
		int step1 = 1;
		int step2 = 1;
		int result = 0;
		for (int i = 2; i <= n; i++) {
			result = step1 + step2;
			step1 = step2;
			step2 = result;
		}
		return result;
	 }
 }
 
 
 
 
