
class MinimumNumberOfDaysToMakeMBouquets {
    class Solution {
        public int minDays(int[] bloomDay, int m, int k) {
            int n = bloomDay.length;
            if((long)m * k > n) return -1;
            
            int maxDay = 0;
            for(int i = 0; i < n; i++){
                maxDay = Math.max(bloomDay[i], maxDay);    
            }
            
            // BinarySearch
            int right = maxDay;
            int left = 1;
            int minDays = Integer.MAX_VALUE;
            while(left <= right){
                int mid = left + (right - left)/2; 
                
                if(checkMinDays(bloomDay, mid, k,m)){
                    minDays = Math.min(minDays, mid);
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
            
            return minDays;
            
        }
        
        private boolean checkMinDays(int[] bloomDay, int days, int k, int m){
            int count = 0;
            for(int i = 0; i < bloomDay.length; i++){
                if(bloomDay[i] > days) {
                    // Looking for consecutive
                    count = 0;
                }
                else {
                    count++;
                }
                
                if(count == k) {
                    m--;
                    count = 0;
                }            
            }
                
            return m <= 0;
        }
    }
}
