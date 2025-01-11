
class MinimumNumberOfChangesToMakeBinaryStringBeautiful {
    class Solution {
        public int minChanges(String s) {
            int changes = 0;
            
            int count = 1;
            char c = s.charAt(0);
            
            for(int i = 1; i < s.length(); i++){
                if(s.charAt(i) != c){                
                    if (count % 2 == 1) {
                        changes++;                    
                        count = -1;                    
                    }
                    else{
                        c = s.charAt(i);
                        count = 0;
                    }                
                }            
               count++;         
            }
            
            return changes;
        }
    }
}
