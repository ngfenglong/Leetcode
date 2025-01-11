import java.util.*;

class ReverseSubstringsBetweenEachPairOfParentheses {
    
    class Solution {
        public String reverseParentheses(String s) {
            Stack<String> stack = new Stack<>();
            
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(c == '('){
                    stack.push(sb.toString());
                    sb = new StringBuilder();
                }
                else if(c == ')'){
                    String str = reverseString(sb.toString());                
                    sb = new StringBuilder();                
                    if(!stack.isEmpty()) sb.append(stack.pop());
                    sb.append(str);
                }
                else {
                    sb.append(c);
                }
            }
            
            if(sb.length() > 0){
                stack.push(sb.toString());
            }
            
            Stack<String> tempStack = new Stack<>();
            while(!stack.isEmpty()){
                tempStack.push(stack.pop());
            }
            
            sb = new StringBuilder();
            while(!tempStack.isEmpty()){
                sb.append(tempStack.pop());
            }
            
            return sb.toString();
                
        }
        
        private String reverseString(String s){
            StringBuilder sb = new StringBuilder();
            for(int i = s.length() - 1; i >= 0; i--){
                sb.append(s.charAt(i));
            }
            
            return sb.toString();
        }
    }
}
