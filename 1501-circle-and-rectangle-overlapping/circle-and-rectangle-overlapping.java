class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int a = Math.max(x1 , Math.min(xCenter , x2));
        int b = Math.max(y1 , Math.min(yCenter , y2));

        int dis1 = (a - xCenter);
        int dis2 = (b - yCenter);
        int sq = (dis1 * dis1) + (dis2 * dis2);

        return sq <= radius * radius;
    }
}