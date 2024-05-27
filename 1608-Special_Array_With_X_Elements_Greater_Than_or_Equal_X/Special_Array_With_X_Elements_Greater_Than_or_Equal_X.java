class Solution {
    public int specialArray(int[] nums) {
        int[] freq = new int[nums.length + 1];
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= nums.length){
                freq[nums[i]]++;
            }
            else {
                sum++;
            }
        }
        
        for(int i = nums.length; i > 0; i--){
            sum += freq[i];
            if(sum == i) return i;
        }
        
        return -1;
    }
}