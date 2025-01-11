import java.util.*;

class FinalArrayStateAfterKMultiplicationOperationsI {
    
    class Solution {
        public int[] getFinalState(int[] nums, int k, int multiplier) {
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>((arr1, arr2) -> {
                if(arr1[0] == arr2[0]) return Integer.compare(arr1[1], arr2[1]);
                return Integer.compare(arr1[0], arr2[0]);
            });
            
            
            for(int i = 0; i < nums.length; i++){
                pq.add(new int[]{nums[i], i});
            }
            
            while(k > 0){
                int[] ele = pq.poll();
                
                ele[0] = ele[0] * multiplier;
                nums[ele[1]] = ele[0];
                
                pq.add(ele);
                k--;
            }
                
            return nums;
        }
    }
}
