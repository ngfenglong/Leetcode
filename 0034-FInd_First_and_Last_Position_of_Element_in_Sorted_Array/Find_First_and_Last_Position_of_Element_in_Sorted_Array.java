class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftLimit = -1;
        int rightLimit = -1;
        
        int targetIdx = binarySearch(0, nums.length - 1, target, nums);
        if (targetIdx > -1){
            leftLimit = targetIdx;
            rightLimit = targetIdx;
            
            while(leftLimit > 0 && nums[leftLimit - 1] == target){
                leftLimit = binarySearch(0, leftLimit - 1, target, nums);
            }
            while(rightLimit < nums.length - 1 && nums[rightLimit + 1] == target){
                rightLimit = binarySearch(rightLimit + 1, nums.length - 1, target, nums);
            }
        }
            
        return new int[]{leftLimit, rightLimit};
        
    }
    
    private int binarySearch(int start, int end, int target, int[] nums){
        int left = start;
        int right = end;
        
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target)  right = mid - 1;
            else left = mid + 1;
        }
        
        return -1;
    }
}