/*
Given a range [m, n] where 0 <= m <= n <= 2147483647, 
return the bitwise AND of all numbers in this range, inclusive.
For example, given the range [5, 7], you should return 4.
*/

//solution1
public int rangeBitwiseAnd(int m, int n) {
     while (n > m) {
          n = n & (n - 1);
     }
     return m & n;
}

//solution2
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m > n) {
            return 0;
        }
        int i = 0;
        // find common prefix
        while(m != n && m != 0) {
            m = m >> 1;
            n = n >> 1;
            i++;
        }
        return m << i;
    }
}

