import java.util.*;

class MakeTheStringGreat {
    
    class Solution {
        public String makeGood(String s) {
            int difference = 'a' - 'A';
            Stack<Character> stack = new Stack<>();
            
            char[] arr = s.toCharArray();
            for(int i = 0; i < arr.length; i++){
                if(stack.isEmpty()){
                    stack.push(arr[i]);
                }
                else {
                    if(Math.abs(stack.peek() - arr[i]) == difference){
                        stack.pop();
                    }
                    else {
                        stack.push(arr[i]);
                    }
                }
            }
            
            StringBuilder sb = new StringBuilder();
            for(char c: stack){
                sb.append(c);
            }
            
            return sb.toString();
        }
    }
}
