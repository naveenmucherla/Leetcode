class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        
        // 1. Identify if the initial array matches a Forward (F) or Reversed (R) state
        int sF = nums[0];
        boolean isF = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] != (i + sF) % n) {
                isF = false;
                break;
            }
        }
        
        int sR = nums[0];
        boolean isR = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] != (-i + sR + n) % n) {
                isR = false;
                break;
            }
        }
        
        // If it doesn't match any valid configuration, it's impossible to sort
        if (!isF && !isR) return -1;
        
        // 2. Setup BFS structures
        int[] distF = new int[n];
        int[] distR = new int[n];
        Arrays.fill(distF, -1);
        Arrays.fill(distR, -1);
        
        // Use flat primitive arrays for the queue to maximize performance
        int[] qType = new int[2 * n + 2];
        int[] qS = new int[2 * n + 2];
        int head = 0, tail = 0;
        
        // Enqueue the initial state(s)
        if (isF) {
            distF[sF] = 0;
            qType[tail] = 0; // 0 represents Forward state
            qS[tail] = sF;
            tail++;
        }
        if (isR) {
            distR[sR] = 0;
            qType[tail] = 1; // 1 represents Reversed state
            qS[tail] = sR;
            tail++;
        }
        
        // 3. Execute BFS
        while (head < tail) {
            int type = qType[head];
            int s = qS[head];
            head++;
            
            // Target achieved: Forward state with shift 0 is the sorted array [0, 1, ..., n-1]
            if (type == 0 && s == 0) {
                return distF[0];
            }
            
            int currentDist = (type == 0) ? distF[s] : distR[s];
            
            if (type == 0) {
                // From Forward state F_s:
                // Operation 1: Rotate Left -> Transitions to F_{s+1}
                int nextSF = (s + 1) % n;
                if (distF[nextSF] == -1) {
                    distF[nextSF] = currentDist + 1;
                    qType[tail] = 0;
                    qS[tail] = nextSF;
                    tail++;
                }
                // Operation 2: Reverse -> Transitions to R_{s-1}
                int nextSR = (s - 1 + n) % n;
                if (distR[nextSR] == -1) {
                    distR[nextSR] = currentDist + 1;
                    qType[tail] = 1;
                    qS[tail] = nextSR;
                    tail++;
                }
            } else {
                // From Reversed state R_s:
                // Operation 1: Rotate Left -> Transitions to R_{s-1}
                int nextSR = (s - 1 + n) % n;
                if (distR[nextSR] == -1) {
                    distR[nextSR] = currentDist + 1;
                    qType[tail] = 1;
                    qS[tail] = nextSR;
                    tail++;
                }
                // Operation 2: Reverse -> Transitions to F_{s+1}
                int nextSF = (s + 1) % n;
                if (distF[nextSF] == -1) {
                    distF[nextSF] = currentDist + 1;
                    qType[tail] = 0;
                    qS[tail] = nextSF;
                    tail++;
                }
            }
        }
        
        return -1;

    }
}