class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> qu = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        for(int i : stones){
            qu.offer(i);
        }
        while(qu.size() > 1){
            int s1 = qu.poll();
            int s2 = qu.poll();

            if(s1 != s2){
                qu.offer(s1 - s2);
            }
        }
        return qu.isEmpty() ? 0 : qu.poll();
    }
}