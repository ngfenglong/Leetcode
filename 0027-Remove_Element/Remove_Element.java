class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        int count = nums.length;
        
        while(left <= right){
            if(nums[left] == val){
                nums[left] = nums[right];
                right--;
                count--;
            }
            else{
                left++;
            }
        }
        return count;
    }
}