class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> nav = new PriorityQueue<>();
        for(int[] mat : matrix){
            for(int num : mat){
                nav.offer(num);
            }
        }
        for(int i = 1 ; i < k ; i++){
            nav.poll();
        }
        return nav.peek();
    }
}