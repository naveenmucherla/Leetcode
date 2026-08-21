public class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long minCoin = Long.MAX_VALUE;
        for (int coin : coins) {
            minCoin = Math.min(minCoin, coin);
        }
        List<Long>[] sizeToLcms = getSizeToLcms(coins);
        long low = 1;
        long high = minCoin * k;
        long answer = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (countAmounts(sizeToLcms, mid) >= k) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }

    private long countAmounts(List<Long>[] sizeToLcms, long maxAmount) {
        long totalCount = 0;
        for (int size = 1; size < sizeToLcms.length; size++) {
            for (long lcm : sizeToLcms[size]) {
                long multiples = maxAmount / lcm;
                if (size % 2 == 1) {
                    totalCount += multiples;
                } else {
                    totalCount -= multiples;
                }
            }
        }
        return totalCount;
    }

    private List<Long>[] getSizeToLcms(int[] coins) {
        int n = coins.length;
        int maxMask = 1 << n;
        List<Long>[] sizeToLcms = new ArrayList[n + 1];
        
        for (int i = 0; i <= n; i++) {
            sizeToLcms[i] = new ArrayList<>();
        }

        for (int mask = 1; mask < maxMask; mask++) {
            long currentLcm = 1;
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) {
                    currentLcm = lcm(currentLcm, coins[i]);
                }
            }
            int subsetSize = Integer.bitCount(mask);
            sizeToLcms[subsetSize].add(currentLcm);
        }
        return sizeToLcms;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
}
