/**
 *Given an integer, write a function to determine if it is a power of two.
 *Soltuion:
 *powers of two have one and only one bit set in their binary representation
 */
 
 //solution1
 public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n>0 && (n&(n-1))==0;
    }
}


//solution2
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return (Math.log10(n)/Math.log10(2))%1==0?true:false;
    }
}


