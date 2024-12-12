class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < gifts.length; i++){
            pq.add(gifts[i]);
        }
        
        while(k > 0){            
            if(pq.peek() > 0){
                int floorSq = (int)(Math.sqrt(pq.poll()));
                pq.add(floorSq);
            }    
                        
            k--;
        }
        
        long ans = 0l;
        while(!pq.isEmpty()){
            ans += (long)pq.poll();
        }
        
        return ans;
    }
}