/**
 *Find the total area covered by two rectilinear rectangles in a 2D plane.
 *Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 */
 
 
 public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaOfRectA = (C - A) * (D - B);
        int areaOfRectB = (G - E) * (H - F);
        
        int left = Math.max(A, E);
        int right = Math.min(G, C);
        int bottom = Math.max(F, B);
        int top = Math.min(D, H);
        
        int overlap = 0;
        if (right > left && top > bottom) {
            overlap = (right - left) * (top - bottom);
        }
        
        return areaOfRectA + areaOfRectB - overlap;
    }
}

