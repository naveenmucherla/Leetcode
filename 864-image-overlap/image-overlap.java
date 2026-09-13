class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int maxOverlap = 0;
        int n = img1.length;

        // Try every possible shift vector from -(n-1) to (n-1)
        for (int rowShift = -n + 1; rowShift < n; rowShift++) {
            for (int colShift = -n + 1; colShift < n; colShift++) {
                maxOverlap = Math.max(maxOverlap, shiftAndCount(img1, img2, rowShift, colShift, n));
            }
        }

        return maxOverlap;
    }

    // Helper method to count overlapping 1s for a specific shift configuration
    private int shiftAndCount(int[][] img1, int[][] img2, int rowShift, int colShift, int n) {
        int count = 0;
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int img1Row = r + rowShift;
                int img1Col = c + colShift;
                
                // Ensure the shifted coordinates stay inside img1 boundaries
                if (img1Row >= 0 && img1Row < n && img1Col >= 0 && img1Col < n) {
                    if (img1[img1Row][img1Col] == 1 && img2[r][c] == 1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
