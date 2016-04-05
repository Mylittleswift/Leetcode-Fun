/*
Implement pow(x, n).
*/

public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        int exp = Math.abs(n);
        double half = myPow(x, exp >> 1);
        double res = half * half;
        if (exp % 2 == 1) {
            res *= x;
        }
        return (n > 0) ? res : 1.0/res;
    }
}

