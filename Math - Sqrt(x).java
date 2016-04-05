/*
Implement int sqrt(int x).
Compute and return the square root of x.
*/

public class Solution {
    public int mySqrt(int x) {
        int l = 1, r = x / 2 + 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (m <= x / m && x / (m + 1) < m + 1) return m;
            if (x / m < m) r = m - 1;
            else l = m + 1;
        }
        return 0;
    }
}

