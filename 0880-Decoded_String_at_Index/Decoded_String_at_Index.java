class Solution {
    public String decodeAtIndex(String s, int k) {
        long decodedLength = 0;
        
        // get the total length of the decoded text
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(isDigit(c)){
                decodedLength *= c - '0';
            }
            else {
                decodedLength++;
            }
        }
        
        // Work backward to find the character --> Dont have to store the string which might result to out of memory
        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            k %= decodedLength;
            if(k == 0 && !isDigit(c))   // If k == 0, it means it is a the "correct" iteration, return the next non-digit character
                return "" + c;
            
            if(isDigit(c)){
                decodedLength /= c - '0';
            }
            else{
                decodedLength--;
            }
        }
        
        return "";
    }
    
    private boolean isDigit(char c){
        return c >= '2' && c <= '9';
    }
}

