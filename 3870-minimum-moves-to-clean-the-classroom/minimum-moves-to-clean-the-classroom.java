
class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length(); // Fixed column bounds check

        int startR = -1, startC = -1;
        
        // Cache litter positions using a simple fixed array for blazing fast lookups
        int[][] litterPos = new int[15][2]; 
        int totalLitter = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char ch = classroom[r].charAt(c);
                if (ch == 'S') {
                    startR = r;
                    startC = c;
                } else if (ch == 'L') {
                    litterPos[totalLitter][0] = r;
                    litterPos[totalLitter][1] = c;
                    totalLitter++;
                }
            }
        }

        int targetMask = (1 << totalLitter) - 1;
        if (totalLitter == 0) {
            return 0;
        }

        // Fast primitive state tracker instead of HashSet
        // visited[row][col][bitmask][remaining_energy]
        boolean[][][][] visited = new boolean[m][n][1 << totalLitter][energy + 1];

        // Flatten the queue to avoid state instantiation overhead
        // Each element holds an array layout: [row, col, mask, energy]
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startR, startC, 0, energy});
        visited[startR][startC][0][energy] = true;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                int mask = curr[2];
                int currEnergy = curr[3];

                if (mask == targetMask) {
                    return moves;
                }

                if (currEnergy == 0) {
                    continue;
                }

                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && classroom[nr].charAt(nc) != 'X') {
                        int nextEnergy = currEnergy - 1;
                        int nextMask = mask;
                        char nextChar = classroom[nr].charAt(nc);

                        if (nextChar == 'L') {
                            for (int k = 0; k < totalLitter; k++) {
                                if (litterPos[k][0] == nr && litterPos[k][1] == nc) {
                                    nextMask |= (1 << k);
                                    break;
                                }
                            }
                        }

                        if (nextChar == 'R') {
                            nextEnergy = energy;
                        }

                        if (!visited[nr][nc][nextMask][nextEnergy]) {
                            visited[nr][nc][nextMask][nextEnergy] = true;
                            queue.add(new int[]{nr, nc, nextMask, nextEnergy});
                        }
                    }
                }
            }
            moves++;
        }

        return -1;
    }
}
