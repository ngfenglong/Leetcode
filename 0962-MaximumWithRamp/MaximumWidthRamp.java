import java.util.*;

class MaximumWidthRamp {
    
    class Solution {
        public int maxWidthRamp(int[] nums) {
            Stack<Integer> monoStack = new Stack<>();
            
            for(int i = 0; i < nums.length - 1; i++){
                if(monoStack.isEmpty()) monoStack.push(i);
                else {
                    if(nums[i] < nums[monoStack.peek()]) monoStack.push(i); 
                }
            }
            
            int maxWidth = 0;
            for(int i = nums.length - 1; i >= 0; i--){
                if(monoStack.isEmpty()) return maxWidth;
                
                while(!monoStack.isEmpty() && nums[monoStack.peek()] <= nums[i]){
                    int idx = monoStack.pop();
                    maxWidth = Math.max(maxWidth, i - idx);
                }
            }
            
            return maxWidth;
        }
    }
}
