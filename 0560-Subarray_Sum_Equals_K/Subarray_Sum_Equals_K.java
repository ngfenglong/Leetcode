class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        hm.put(0,1);
        int cummulative = 0;
        int ans = 0 ;
        for(int i = 0 ; i < nums.length; i++){
            cummulative += nums[i];
            if(hm.containsKey(cummulative - k)) {
                ans += hm.get(cummulative - k);
            }
            
            
            hm.put(cummulative, hm.getOrDefault(cummulative, 0) + 1);
            
        }
        
        return ans;
    }
}