
class LongestCommonPrefix {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            StringBuilder sb = new StringBuilder();
            String firstWord = strs[0];
            
            char c;
            
            for(int j = 0; j < firstWord.length(); j++){
                c = firstWord.charAt(j);
                
                for(int i = 0; i < strs.length; i++){
                   if(j >= strs[i].length() || strs[i].charAt(j) != c) return sb.toString();
                }
                sb.append(c);
            }
            
            return sb.toString();
        }
    }
}
