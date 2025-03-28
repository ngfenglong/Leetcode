
class SearchInsertPosition {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            
            int left = 0; 
            int right = nums.length-1;
            int mid = (right - left)/2 + left;
            while(left <= right){
                mid = (right - left)/2 + left;
                if(nums[mid] == target) return mid;
                
                else if(nums[mid] < target) left = mid + 1;
                else right = mid - 1;
            }
            
            return right + 1;
            
        }
    }
}
