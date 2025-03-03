import java.util.*;

public class ParitionArrayAccordingToGivenPivot {
    class Solution {
        public int[] pivotArray(int[] nums, int pivot) {
            int[] ans = new int[nums.length];
            Queue<Integer> pivotsQ = new LinkedList<>();
            Queue<Integer> greaterQ = new LinkedList<>();
    
            int p = 0;        
            for(int i = 0; i < nums.length; i++){
                if(nums[i] < pivot){
                    ans[p++] = nums[i];
                }            
                else if(nums[i] == pivot){
                    pivotsQ.add(nums[i]);
                }
                else {
                    greaterQ.add(nums[i]);
                }
            }
    
            while(!pivotsQ.isEmpty()) ans[p++] = pivotsQ.poll();
    
            while(!greaterQ.isEmpty()) ans[p++] = greaterQ.poll();
            
            return ans;
        }
    }
}