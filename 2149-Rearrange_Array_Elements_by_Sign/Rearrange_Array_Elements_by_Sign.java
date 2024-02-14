class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        
        int posIdx = 0;
        int negIdx = 0;
        
        while(nums[posIdx] < 0) posIdx++;
        while(nums[negIdx] > 0) negIdx++;
        
        int i = 0;
        
        while(i < nums.length){
            ans[i++] = nums[posIdx++];
            ans[i++] = nums[negIdx++];
            
            while(posIdx < nums.length && nums[posIdx] < 0) posIdx++;
            while(negIdx < nums.length && nums[negIdx] > 0) negIdx++;
        }
        
        return ans;
    }
}