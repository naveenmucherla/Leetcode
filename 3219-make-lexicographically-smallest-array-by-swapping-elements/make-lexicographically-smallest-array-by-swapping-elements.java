class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        
        // Step 1: Create a sorted copy of the original array
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        
        // Maps a number to its group index identifier
        Map<Integer, Integer> numToGroup = new HashMap<>();
        // Stores elements belonging to each group in a FIFO queue (maintains sorted order)
        List<Queue<Integer>> groupList = new ArrayList<>();
        
        int groupIdx = 0;
        numToGroup.put(sortedNums[0], groupIdx);
        groupList.add(new LinkedList<>());
        groupList.get(groupIdx).offer(sortedNums[0]);
        
        // Step 2: Group elements where consecutive sorted difference <= limit
        for (int i = 1; i < n; i++) {
            if (sortedNums[i] - sortedNums[i - 1] > limit) {
                groupIdx++;
                groupList.add(new LinkedList<>());
            }
            numToGroup.put(sortedNums[i], groupIdx);
            groupList.get(groupIdx).offer(sortedNums[i]);
        }
        
        // Step 3: Rebuild the array by replacing original elements with the 
        // smallest available element from their respective groups
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int group = numToGroup.get(nums[i]);
            result[i] = groupList.get(group).poll();
        }
        
        return result;
    }
}