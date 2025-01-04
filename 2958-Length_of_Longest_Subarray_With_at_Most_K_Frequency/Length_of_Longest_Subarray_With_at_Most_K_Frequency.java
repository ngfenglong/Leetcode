import java.util.*;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while(right < nums.length){
            int curr = nums[right];
            int val = freq.getOrDefault(curr, 0);
            
            if(val + 1 > k){
                 while(left <= right && nums[left] != curr){
                    freq.put(nums[left], freq.get(nums[left]) - 1);
                    left++;
                }
                left++;
                val--;
            }
            
            freq.put(curr, val + 1);
            right++;
            max = Math.max(max, right - left);
        }
        
        return max;
    }
}