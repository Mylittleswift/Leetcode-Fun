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
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;
import java.util.Collections;


// solution 1
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
 
 
// solution 2
class WordNode{
    String word;
    int numSteps;
    WordNode pre;
 
    public WordNode(String word, int numSteps, WordNode pre){
        this.word = word;
        this.numSteps = numSteps;
        this.pre = pre;
    }
}

public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();
 
        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(start, 1, null));
 
        dict.add(end);
 
        int minStep = 0;
 
        HashSet<String> visited = new HashSet<String>();  
        HashSet<String> unvisited = new HashSet<String>();  
        unvisited.addAll(dict);
 
        int preNumSteps = 0;
 
        while(!queue.isEmpty()){
            WordNode top = queue.remove();
            String word = top.word;
            int currNumSteps = top.numSteps;
 
            if(word.equals(end)){
                if(minStep == 0){
                    minStep = top.numSteps;
                }
 
                if(top.numSteps == minStep && minStep !=0){
                    //nothing
                    ArrayList<String> t = new ArrayList<String>();
                    t.add(top.word);
                    while(top.pre !=null){
                        t.add(0, top.pre.word);
                        top = top.pre;
                    }
                    result.add(t);
                    continue;
                }
 
            }
 
            if(preNumSteps < currNumSteps){
                unvisited.removeAll(visited);
            }
 
            preNumSteps = currNumSteps;
 
            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }
 
                    String newWord = new String(arr);
                    if(unvisited.contains(newWord)){
                        queue.add(new WordNode(newWord, top.numSteps+1, top));
                        visited.add(newWord);
                    }
 
                    arr[i]=temp;
                }
            }
 
 
        }
 
        return result;
    }
}


