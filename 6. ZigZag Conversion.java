/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<List<Character>> lists = new ArrayList<List<Character>>();
        for (int i = 0; i < numRows; i++) {
            lists.add(new ArrayList<Character>());
        }
        int i = 0;
        while (i < s.length()) {
            for (int a = 0; a < numRows && i < s.length(); a++) {
                lists.get(a).add(s.charAt(i));
                i++;
            }
            for (int b = 0; b < numRows - 2 && i < s.length(); b++) {
                lists.get(numRows - 2 - b).add(s.charAt(i));
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (List<Character> list : lists) {
            for (char c : list) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

