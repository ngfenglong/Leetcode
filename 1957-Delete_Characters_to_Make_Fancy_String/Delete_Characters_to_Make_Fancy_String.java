class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        char prev = '.';
        char prev2 = '.';
            
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            
            if(!(prev == prev2 && prev == curr)){
                 sb.append(curr);
            }
            
            prev2 = prev;
            prev = curr;
        }
        
        return sb.toString();
    }
}