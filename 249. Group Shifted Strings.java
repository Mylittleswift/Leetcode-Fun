/*
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence: 

"abc" -> "bcd" -> ... -> "xyz" 
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence. 

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
Return: 

[ 
  ["abc","bcd","xyz"], 
  ["az","ba"], 
  ["acef"], 
  ["a","z"] 
] 
Note: For the return value, each inner list's elements must follow the lexicographic order. 
*/



public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strings) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                int l = (s.charAt(i) - s.charAt(0) + 26) % 26;
                sb.append(l + " ");
                
            }
            String str = sb.toString();
            if (!map.containsKey(str)) {
                List<String> tem = new ArrayList<String>();
                map.put(str, tem);
            }
            map.get(str).add(s);
        }
        for (String m : map.keySet()) {
            Collections.sort(map.get(m));
            res.add(map.get(m));
        }
        return res;
    }
}


