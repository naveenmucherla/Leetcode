class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> nav = new PriorityQueue<>((a,b) -> Integer.compare(b , a));
        for(int num : nums){
            nav.offer(num);
        }
        for(int i = 1 ; i < k ; i++){
            nav.poll();
        } 
     return nav.peek();
    }
}