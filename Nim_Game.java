/**
*as long as the heap of stones is a multiple of 4, eventually he will win.
*/

public class Solution {
    public boolean canWinNim(int n) {
        if(n%4 !=0) {return true;}
        return false;
    }
}


