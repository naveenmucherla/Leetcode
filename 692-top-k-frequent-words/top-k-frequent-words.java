class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> hash = new HashMap<>();
        for(String s : words){
            hash.put(s , hash.getOrDefault(s , 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((a , b) -> {
            if(hash.get(a).equals(hash.get(b))){
                return b.compareTo(a);
            }
           return  Integer.compare(hash.get(a) , hash.get(b));
            });

        for(String str : hash.keySet()){
            pq.offer(str);
            if(pq.size() > k){
                pq.poll();
            }
        }

        ArrayList<String> arr = new ArrayList<>();
        while(!pq.isEmpty()){
            arr.add(pq.poll());
        }
        Collections.reverse(arr);
        return arr;
    }
}