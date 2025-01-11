
class AddingSpacesToAString {
    class Solution {
        public String addSpaces(String s, int[] spaces) {
            StringBuilder sb = new StringBuilder();
            
            int spaceIdx = 0;
            
            for(int i = 0; i < s.length(); i++){            
                if(spaceIdx < spaces.length && spaces[spaceIdx] == i){
                    sb.append(" ");
                    spaceIdx++;
                }    
                
                sb.append(s.charAt(i));
            }
            
            return sb.toString();
        }
    }
}
