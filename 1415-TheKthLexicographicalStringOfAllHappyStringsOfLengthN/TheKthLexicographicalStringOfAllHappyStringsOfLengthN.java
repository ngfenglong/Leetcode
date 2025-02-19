import java.util.List;
import java.util.ArrayList;

public class TheKthLexicographicalStringOfAllHappyStringsOfLengthN {
    class Solution {
        final char[] LETTERS = new char[]{'a','b','c'};
        public String getHappyString(int n, int k) {
            List<String> list = new ArrayList<>();
            formWords(list, n, k, new StringBuilder());
    
            if(k > list.size()) return "";
            
            return list.get(k - 1);
        }
    
        private void formWords(List<String> list, int n, int k, StringBuilder sb){
            if(sb.length() == n) {
                list.add(new String(sb.toString()));
                return;
            }
    
            if(list.size() >= k) return;
    
            for(char c : LETTERS){
                if(sb.length() == 0 || c != sb.charAt(sb.length() - 1)){
                    sb.append(c);
                    formWords(list, n, k, sb);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }    
}
