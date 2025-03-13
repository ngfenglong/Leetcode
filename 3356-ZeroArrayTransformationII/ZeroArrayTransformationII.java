public class ZeroArrayTransformationII {
    class Solution {
        public int minZeroArray(int[] nums, int[][] queries) {
            int left = 0, right = queries.length;
    
            if(!currentZeroArray(queries.length, queries, nums)) return -1;
    
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(currentZeroArray(mid, queries, nums)){
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
    
            return left;
        }
    
        private boolean currentZeroArray(int k, int[][] queries, int[] nums){
            int[] differences = new int[nums.length + 1];
    
            for(int i = 0; i < k; i++){
                int l = queries[i][0], r = queries[i][1], val = queries[i][2];
    
                differences[l] += val;
                differences[r + 1] -= val;
            }
    
            int sum = 0;
            for(int i = 0; i < nums.length; i++){
                sum += differences[i];
                if(sum < nums[i]) return false;
            }
    
            return true;
        }
    }
}