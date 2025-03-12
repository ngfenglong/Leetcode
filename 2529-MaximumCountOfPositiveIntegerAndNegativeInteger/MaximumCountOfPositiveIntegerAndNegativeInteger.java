public class MaximumCountOfPositiveIntegerAndNegativeInteger {
    class Solution {
        public int maximumCount(int[] nums) {
            int neg = findLowerBoundary(nums);
            int pos = nums.length - findUpperBoundary(nums);
    
            return Math.max(pos, neg);
        }
    
    
        private int findUpperBoundary(int[] arr){
            int left = 0; 
            int right = arr.length - 1;
            int idx = arr.length;
    
            while (left <= right){
                int mid = (left + right)/2;
                if(arr[mid] > 0){
                    right = mid - 1;
                    idx = mid;
                }
                else {
                    left = mid + 1;
                }
            }
    
            return idx;
        }
    
    
        // First zero or more value idx
        private int findLowerBoundary(int[] arr){
            int left = 0; 
            int right = arr.length - 1;
            int idx = arr.length;
    
            while (left <= right){
                int mid = (left + right)/2;
                if(arr[mid] < 0){
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                    idx = mid;
                }
            }
    
            return idx;
        }
    }
}