class Solution {
    public long maxKelements(int[] nums, int k) {
        long count = 0l;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return Integer.compare(b,a);
            }
        });
        
        
        for(int i = 0; i < nums.length; i++){
            queue.add(nums[i]);
        }
        
        while(k > 0){
            int val = queue.poll();
            
            if(val == 0) return count;
            
            count += (long)val;
            queue.add((val + 2) / 3);
            k--;
        }
        
        return count;
    }
}