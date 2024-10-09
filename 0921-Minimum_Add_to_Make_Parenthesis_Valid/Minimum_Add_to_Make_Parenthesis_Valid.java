class Solution {
    public int minAddToMakeValid(String s) {
        int count = 0;
        int openBrackets = 0;
        
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == '('){
              openBrackets++;  
            } else {
                if(openBrackets > 0) openBrackets--;
                else count++;
            }
        }
        
        count += openBrackets;
        return count;
    }
}