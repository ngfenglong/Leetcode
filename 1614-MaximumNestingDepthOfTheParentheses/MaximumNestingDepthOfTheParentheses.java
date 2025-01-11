
class MaximumNestingDepthOfTheParentheses {
    class Solution {
        public int maxDepth(String s) {
            int maxDepth = 0;
            int currDepth = 0;
            
            char[] arr = s.toCharArray();
            for(char c: arr){
                if(c == '('){
                    currDepth++;
                    maxDepth = Math.max(currDepth, maxDepth);
                }
                if(c == ')') currDepth--;
            }
            
            return maxDepth;
        }
    }
}
