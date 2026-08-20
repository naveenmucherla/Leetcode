class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      if(nums.length == 0 || k <= 0 )
       return new int[0];

       int m = nums.length;
       int[] result = new int[m-k+1];
       int resultIndex = 0;
       Deque<Integer> deque = new ArrayDeque<>();
       for(int i = 0 ; i < m ; i++){
          if(!deque.isEmpty() && deque.peekFirst() < i - k + 1)
            deque.pollFirst();
          while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
           deque.pollLast();

           deque.offerLast(i);

           if(i >= k -1){
            result[resultIndex++] = nums[deque.peekFirst()];
           }
       }
       return result;
    }
}