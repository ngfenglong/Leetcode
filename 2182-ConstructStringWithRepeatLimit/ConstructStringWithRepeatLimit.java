
class ConstructStringWithRepeatLimit {
    class Solution {
        public String repeatLimitedString(String s, int repeatLimit) {
            int[] charFrequency = new int[26];
            
            for (char c : s.toCharArray()) {
                charFrequency[c - 'a']++;
            }
            
            
            StringBuilder sb = new StringBuilder();
            int currentChar = 25;
            int prevChar = 24;
            
            while(currentChar >= 0 && prevChar >= 0){
                while(currentChar >= 0 && charFrequency[currentChar] == 0) currentChar--;
                
                if(currentChar < 0) break;
                
                int currCount = 0;
                while(charFrequency[currentChar] > 0 && currCount < repeatLimit){
                    sb.append((char)('a' + currentChar));
                    currCount++;
                    charFrequency[currentChar]--;
                }
                
                if(charFrequency[currentChar] > 0){
                    prevChar = currentChar - 1;
                    
                    while(prevChar >= 0 && charFrequency[prevChar] == 0) prevChar--;
                    
                    if(prevChar < 0) break;
                    
                    else {
                        charFrequency[prevChar]--;
                        sb.append((char)('a' + prevChar));
                    }
                }
                else{
                    currentChar--;
                }
    
            }
            
            return sb.toString();
        }
    }
}
