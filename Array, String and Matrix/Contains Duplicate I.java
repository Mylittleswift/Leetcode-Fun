 /**
  *Given an array of integers, find if the array contains any duplicates. 
  *Your function should return true if any value appears at least twice in the array, 
  *and it should return false if every element is distinct.
  */
  
 //Solution1
 public class Solution {
     public boolean containsDuplicate(int[] nums) {
         if (nums == null || nums.length <= 1) {
             return false;
         }
         Arrays.sort(nums);
         for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return true;
            }
         }
         return false;
     }
 }


  //Solution2 - hashset
  public class Solution {
      public boolean containsDuplicate(int[] nums) {
          if (nums == null || nums.length == 0) {
              return false;
           }
           HashSet<Integer> set = new HashSet<>();
           for (int n : nums) {
               if (!set.add(n)) {
                  return true;
               }
           }
           return false;
      }
  }

  
