/**
*Note: This is an extension of House Robber.
*After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. 
*That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.
*Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/

public class Solution {
    public int rob(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int pHouse2 = 0; //house at pos - 2
            int pHouse1 = nums[i]; //house at pos - 1
            int house = pHouse1; //current house
            for (int j = 2; j < nums.length; j++) { //second house -> second to last house, as last house is not rob-able
                house = Math.max(pHouse2 + nums[(i + j - 1) % nums.length], pHouse1);
                pHouse2 = pHouse1;
                pHouse1 = house;
            }
            result = Math.max(result, house);
        }
        return result;
    }
}

