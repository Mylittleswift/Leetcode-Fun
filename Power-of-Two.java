/**
 *Given an integer, write a function to determine if it is a power of two.
 *Soltuion:
 *powers of two have one and only one bit set in their binary representation
 */
 
 public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n>0 && (n&(n-1))==0;
    }
}

