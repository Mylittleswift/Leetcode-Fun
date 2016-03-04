/*
This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
word1 and word2 may be the same and they represent two individual words in the list.
For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
Given word1 = “makes”, word2 = “coding”, return 1.
Given word1 = "makes", word2 = "makes", return 3.
*/

public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int posA = -1;
        int posB = -1;
        int minDistance = Integer.MAX_VALUE;
         
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
             
            if (word.equals(word1)) {
                posA = i;
            } else if (word.equals(word2)) {
                posB = i;
            }
             
            if (posA != -1 && posB != -1 && posA != posB) {
                minDistance = Math.min(minDistance, Math.abs(posA - posB));
            }
             
            if (word1.equals(word2)) {
                posB = posA;
            }
        }
         
        return minDistance;
    }
}

