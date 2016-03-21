/**
 *Given an integer n, return the number of trailing zeroes in n!.
 *Note: Your solution should be in logarithmic time complexity.
 */
 
 //Recurisive solution
 public class Solution {
    public int trailingZeroes(int n) {
        if (n <= 0) {
            return 0;
        }
        return n / 5 + trailingZeroes(n / 5);
    }
}



//Iterative solution
public class Solution {
    public int trailingZeroes(int n) {
       if (n < 0) {
		return -1;
       }
 
	   int count = 0;
	   for (long i = 5; n / i >= 1; i *= 5) { //use long instead of int i
		   count += n / i;
	   }
	   return count;
    }
}


 
