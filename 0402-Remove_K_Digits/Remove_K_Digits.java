import java.util.*;

class Solution {
  public String removeKdigits(String num, int k) {
   // check for special case --> second number has 0
   // flow -> if [i] > [i + 1] --> remove i
   // else remove from behind
    LinkedList<Character> stack = new LinkedList<Character>();
        
    for(char digit : num.toCharArray()) {
      while(stack.size() > 0 && k > 0 && stack.peekLast() > digit) {
        stack.removeLast();
        k -= 1;
      }
      stack.addLast(digit);
    }
        
    /* remove the remaining digits from the tail. */
    for(int i=0; i<k; ++i) {
      stack.removeLast();
    }
        
    // build the final string, while removing the leading zeros.
    StringBuilder sb = new StringBuilder();
    boolean leadingZero = true;
    for(char digit: stack) {
      if(leadingZero && digit == '0') continue;
      leadingZero = false;
      sb.append(digit);
    }
        
    
    if (sb.length() == 0) return "0";
    return sb.toString();
  }
}