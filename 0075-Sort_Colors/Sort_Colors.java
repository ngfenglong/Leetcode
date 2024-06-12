class Solution {
    public void sortColors(int[] nums) {
        int curr = 0;
        int p0 = 0;
        int p2 = nums.length - 1;
        
        while(curr <= p2){
            if(nums[curr] == 0){
                swap(nums, curr, p0);
                p0++;
                curr++;
                
            }
            else if(nums[curr] == 2){
                swap(nums, curr, p2);
                p2--;
            }
            else {
                curr++;
            }
        }
        
    }
    
    private void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
        
}