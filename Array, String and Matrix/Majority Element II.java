/*
Given an integer array of size n, find all elements that appear more than n/3 times.
The algorithm should run in linear time and in O(1) space.
Hint:
How many majority elements could it possibly have?
*/

//solution1 Time = O(n) and Space = O(1)
public class Solution {
  public List<Integer> majorityElement(int[] nums) {
      List<Integer> result = new ArrayList<Integer>();
 
      Integer n1=null, n2=null;
      int c1=0, c2=0;
 
      for (int i: nums) {
          if (n1 != null && i == n1.intValue()) {
              c1++;
          } else if (n2 != null && i == n2.intValue()) {
              c2++;
          }else if (c1 == 0) {
              c1 = 1;
              n1 = i;
          } else if (c2 == 0) {
              c2 = 1;
              n2 = i;
          }else{
              c1--;
              c2--;
          }
      }
 
      c1 = c2 = 0;
 
      for (int i: nums) {
          if (i == n1.intValue()) {
              c1++;
          } else if (i == n2.intValue()) {
              c2++;
          }
      }
 
      if (c1 > nums.length/3) {
          result.add(n1);
      }
      if (c2 > nums.length/3) {
          result.add(n2);
      }
       return result;
    }
}


//solution2 Time = O(n) and Space = O(n)
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i: nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i)+1);
            }else{
                map.put(i, 1);
            }
        }
 
        List<Integer> result = new ArrayList<>();
 
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > nums.length/3) {
                result.add(entry.getKey());
            }    
        }

        return result;
    }
}

