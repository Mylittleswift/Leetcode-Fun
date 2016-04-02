/*
Write a program to find the n-th ugly number.
Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note that 1 is typically treated as an ugly number.
*/

public class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        int i = 0, j = 0, k = 0;
         
        while (nums.size() < n) {
            int m2 = nums.get(i) * 2;
            int m3 = nums.get(j) * 3;
            int m5 = nums.get(k) * 5;
            int mn = Math.min(Math.min(m2, m3), m5);
            nums.add(mn);
            if (mn == m2) i++;
            if (mn == m3) j++;
            if (mn == m5) k++;
        }
        return nums.get(nums.size() - 1)
    }
}

