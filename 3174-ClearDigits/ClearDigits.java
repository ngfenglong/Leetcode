import java.util.*;

public class ClearDigits {
    class Solution {
        public String clearDigits(String s) {
            Deque<Character> queue = new LinkedList<>();
    
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    if(!queue.isEmpty()){
                        queue.removeLast();
                    }
                }
                else {
                    queue.addLast(s.charAt(i));
                }
            }
    
            StringBuilder sb = new StringBuilder();
            while(!queue.isEmpty()){
                sb.append(queue.poll());
            }
    
            return sb.toString();
        }
    }
}
