/*
Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
*/


public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int l = 0, r = len - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (citations[m] == len - m) {
                return len - m;
            } else if (citations[m] < len - m) {
                l = m + 1;
            } else { 
                r = m - 1;
            }
        }
        return len - l;
    }
}

