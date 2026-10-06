class Solution {
    public int minAddToMakeValid(String s) {
        int openNeeded = 0;
        int closeNeeded = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                closeNeeded++;
            } else {
                // If we have an open bracket to pair with, pair it
                if (closeNeeded > 0) {
                    closeNeeded--;
                } else {
                    // Otherwise, we need to insert an opening bracket
                    openNeeded++;
                }
            }
        }

        return openNeeded + closeNeeded;
    }
}