/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". 
When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
*/

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> sequenceSet = new HashSet<>();
        Set<Integer> checkSet = new HashSet<>(); //a hashset to check the third appearance of a sequence
        List<String> result = new ArrayList<>();
        char[] map = new char[26];
        //map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
    
        for(int i = 0; i < s.length() - 9; i++) {
            int v = 0;
            for(int j = i; j < i + 10; j++) {
                v |= map[s.charAt(j) - 'A']; //ranges from 0 - 3 = 2 bits
                v <<= 2; 
            }
            if(!sequenceSet.add(v) && checkSet.add(v)) {
                result.add(s.substring(i, i + 10));
            }
        }
        return result;
    }
}

