public class MaximumCandiesAllocatedToKChildren {
    class Solution {
        public int maximumCandies(int[] candies, long k) {
            int left = 1;
            int right = 0;
    
            for(int i = 0; i < candies.length; i++){
                right = Math.max(right, candies[i]);
            }
    
            int ans = 0;
            while(left <= right){
                // Assuming each child is getting "mid" amount of sweets
                int mid = left + (right - left)/2;
    
                if(canSplitCandies(candies, k, mid)){
                    ans = mid;
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
    
            return ans;
        }
    
        private boolean canSplitCandies(int[] candies, long k, int mid){
            for(int i = 0 ; i < candies.length; i++){
                k -= (long) (candies[i] / mid);
                if(k <= 0) return true;
            }
    
            return k <= 0;
        }
    }
}