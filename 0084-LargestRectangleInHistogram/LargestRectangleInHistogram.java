import java.util.*;

public class LargestRectangleInHistogram {
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int max = 0;
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            
            for(int i = 0; i < heights.length; i++){
                if(stack.isEmpty()){
                    stack.push(i);
                    continue;
                }
                
                while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]){
                    int idx = stack.pop();
                    max = Math.max(max, ((i - stack.peek() - 1) * heights[idx]));
                }
    
                stack.push(i);
            }   
    
            while(stack.peek() > -1){
                int idx = stack.pop();
                max = Math.max(max, ((heights.length - stack.peek() - 1) * heights[idx]));
            }
        
            return max;
        }
    }
}