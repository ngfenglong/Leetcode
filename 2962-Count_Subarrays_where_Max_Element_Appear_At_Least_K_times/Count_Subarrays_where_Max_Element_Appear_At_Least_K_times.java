class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxElement = -1;
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            maxElement = Math.max(maxElement, nums[i]);
            if(!hm.containsKey(nums[i])) hm.put(nums[i], new ArrayList<>());
            hm.get(nums[i]).add(i);
        }
        
        List<Integer> list = hm.get(maxElement);
        if(list.size() < k) return 0;
        
        int prev = -1;
        int offset = 0;
        long count = 0l;
        while(offset + k <= list.size()){
            int start = list.get(offset);
            int end = list.get(k + offset - 1);
            count += (long)(start - prev) * (long)(nums.length - end);
            offset++;
            prev = start;
        }
        
        return count;
    }
}