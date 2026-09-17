class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        
        // Loop until we reach 1 or hit a cycle
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        
        return n == 1;
    }

    // Helper method to calculate the sum of squares of digits
    private int getNext(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10; // Java integer division automatically truncates (like Math.floor)
        }
        return sum;
        
   }
}