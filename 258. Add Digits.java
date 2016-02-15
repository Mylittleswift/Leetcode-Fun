/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * For example: 
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 * Wiki: https://en.wikipedia.org/wiki/Digital_root
 * With this in mind the digital root of a positive integer n may be defined by using floor function, as num-9*((num-1)/9)
 */


public class Solution {
    public int addDigits(int num) {
        
        if (num >=0 && num <=9) {return num;}
        return (num-9*((num-1)/9));
    }
}


