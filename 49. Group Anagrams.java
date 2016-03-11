/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
*/

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String str : strs) {
            char[] carr = str.toCharArray();
            Arrays.sort(carr);
            String key = new String(carr);
            List<String> list = map.get(key);
            if (list == null) {
                list = new ArrayList<String>();
            }
            list.add(str);
            map.put(key, list);
        }
        List<List<String>> res = new ArrayList<List<String>>();
        
        for(String key : map.keySet()){
            List<String> curr = map.get(key);
            Collections.sort(curr);
            res.add(curr);
        }
        return res;
    }
}

