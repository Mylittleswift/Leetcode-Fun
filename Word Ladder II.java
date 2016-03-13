/*
Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
All words have the same length.
All words contain only lowercase alphabetic characters.
*/

public class Solution {  
   public List<List<String>> findLadders(String start, String end, Set<String> dict) {  
     List<List<String>> rslt = new ArrayList<List<String>>();  
     Map<String, List<String>> parents = new HashMap<String, List<String>>();  
     boolean found = false;  
       
     // initialize  
     Set<String> cur_layer = new HashSet<String>();  
     cur_layer.add(start);  
     if(dict.contains(start)) dict.remove(start);  
     dict.add(end);  
       
     // BFS construct map  
     while(!found && !cur_layer.isEmpty()){  
       Set<String> new_layer = new HashSet<String>();  
       Iterator<String> iter = cur_layer.iterator();  
       while(iter.hasNext()){  
         String s = iter.next();  
         for(String t: neighbors(s, dict)){  
              new_layer.add(t);  
             if(!parents.containsKey(t)){  
               List<String> list = new ArrayList<String>();  
               list.add(s);  
               parents.put(t,list);  
             }else{  
               List<String> list = parents.get(t);  
               list.add(s);  
             }  
             if(t.equals(end)) found = true;  
         }  
       }  
       dict.removeAll(new_layer);  
       cur_layer = new_layer;  
     }  
       
     // DFS construct paths  
     Stack<String> path = new Stack<String>();  
     path.push(end);  
     dfs(start, end, path, parents, rslt);  
       
     return rslt;  
   }  
     
   private void dfs(String start, String s, Stack<String> path, Map<String, List<String>> parents, List<List<String>> rslt){  
        // base case  
     if(s.equals(start)){  
       List<String> list = new ArrayList<String>();  
       list.addAll(path);  
       Collections.reverse(list);  
       rslt.add(list);  
       return;  
     }  
     // edge case  
        if(!parents.containsKey(s)) return;  
     // recursion  
     for(String t: parents.get(s)){  
       path.push(t);  
       dfs(start, t, path, parents, rslt);  
       path.pop();  
     }  
   }  
     
   private List<String> neighbors(String s, Set<String> dict){   
     List<String> list = new ArrayList<String>();   
     char[] chars = s.toCharArray();   
     for(int j = 0;j < s.length();j++){   
       char original = chars[j];   
       for(char c = 'a';c <= 'z';c++){   
         chars[j] = c;   
         String t = new String(chars);   
         if(!t.equals(s) && dict.contains(t)) list.add(t);   
       }   
       chars[j] = original;   
     }   
     return list;   
   }   
 }  
 
 
