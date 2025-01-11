import java.util.*;

class DailyTemperatures {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int[] answer = new int[temperatures.length];
            Stack<Integer> stack = new Stack<>();
            
            for(int i = 0; i < temperatures.length; i++){
                int currTemp = temperatures[i];
                
                while(!stack.isEmpty() && temperatures[stack.peek()] < currTemp) {
                    int idx = stack.pop();
                    answer[idx] = i - idx;
                }
                
                stack.push(i);
            }
            
            return answer;
        }
    }
}
