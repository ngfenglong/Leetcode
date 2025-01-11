
class MinimumNumbersOfSwapsToMakeTheStringBalanced {
    class Solution {
        public int minSwaps(String s) {
            int openBrackets = 0;
            
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '['){
                    openBrackets++;        
                }
                else {
                    if(openBrackets > 0) openBrackets--;
                }
            }
            
            if(openBrackets == 0) return 0;
            
            return (openBrackets + 1) / 2;
        }
    }
}
