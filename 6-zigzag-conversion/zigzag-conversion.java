class Solution {
    public String convert(String s, int numRows) {
        // Edge case: No conversion needed
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        int n = s.length();
        StringBuilder result = new StringBuilder();
        int cycleLen = 2 * numRows - 2;

        // Process row by row mathematically
        for (int r = 0; r < numRows; r++) {
            for (int i = r; i < n; i += cycleLen) {
                // Add the primary character of the cycle
                result.append(s.charAt(i));

                // If it's a middle row, check for the internal zigzag character
                if (r > 0 && r < numRows - 1) {
                    int secondIndex = i + cycleLen - 2 * r;
                    if (secondIndex < n) {
                        result.append(s.charAt(secondIndex));
                    }
                }
            }
        }

        return result.toString();
    }
}
