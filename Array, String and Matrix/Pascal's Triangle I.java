/** 
 *Given numRows, generate the first numRows of Pascal's triangle.
 *each number in the triangle is the sum of the two directory above it.
 *Go from back to front to avoid overriding
 */
 
 
 public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows < 1) {
            return res;
        }
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        res.add(new ArrayList<Integer>(row));
        for (int i = 2; i <= numRows; i++) {
            row.add(i - 1, row.get(i - 2));
            for (int j = i - 2; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            res.add(new ArrayList<Integer>(row));
        }
        return res;
    }
} 



