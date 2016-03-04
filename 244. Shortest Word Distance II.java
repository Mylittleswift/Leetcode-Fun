/*
This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?
Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.
For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.
*/

public class WordDistance {
    private Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                List<Integer> pos = map.get(words[i]);
                pos.add(i);
                map.put(words[i], pos);
            } else {
                List<Integer> pos = new ArrayList<>();
                pos.add(i);
                map.put(words[i], pos);
            }
        }
    }
 
    public int shortest(String word1, String word2) {
        List<Integer> pos1 = map.get(word1);
        List<Integer> pos2 = map.get(word2);
         
        int minDistance = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (i < pos1.size() && j < pos2.size()) {
            int p1 = pos1.get(i);
            int p2 = pos2.get(j);
            if (p1 < p2) {
                minDistance = Math.min(minDistance, p2 - p1);
                i++;
            } else {
                minDistance = Math.min(minDistance, p1 - p2);
                j++;
            }
        }
         
        return minDistance;
    }
}

