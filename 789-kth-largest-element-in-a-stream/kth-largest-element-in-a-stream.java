class KthLargest {
    PriorityQueue<Integer> aizen = new PriorityQueue<>();
    private int maxsize ;
    public KthLargest(int k, int[] nums) {
        this.maxsize = k;
        for(int num : nums){
           add(num);
        }
    }
    
    public int add(int val) {
        aizen.offer(val);
       while(aizen.size() > maxsize)
        aizen.poll();
      return aizen.peek();
    }
} 

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */