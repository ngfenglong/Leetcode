class Solution {
    public long findScore(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]) return Integer.compare(a[1], b[1]);
                return Integer.compare(a[0], b[0]);
            }
        });
        
        for(int i = 0; i < nums.length; i++){
            pq.add(new int[]{nums[i], i});
        }
        
        
        boolean[] marked = new boolean[nums.length];
        long ans = 0l;
        
        while(!pq.isEmpty()){
            int[] element = pq.poll();
            int idx = element[1];
            int val = element[0];
            
            
            if(marked[idx] == true) {
                continue;
            }
            
            ans += (long) val;
            marked[idx] = true;
            
            if(idx + 1 < nums.length) marked[idx + 1] = true;
            if(idx - 1 >= 0) marked[idx - 1] = true;
        }
        
        return ans;
    }
}