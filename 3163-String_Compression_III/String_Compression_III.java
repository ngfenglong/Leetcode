class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        char c = word.charAt(0);
        int count = 1;
        
        for(int i = 1; i < word.length(); i++){
            char curr = word.charAt(i);
            
            if(curr == c) {
                count++;     
            } 
            
            else {
                if(count > 0) appendCompressedString(sb, c, count);
                
                count = 1;
                c = curr;
            }
            
            if(count == 9) {
                    appendCompressedString(sb, c, count);
                    count = 0;
            }
        }
        
        if(count > 0) {
            appendCompressedString(sb, c, count);
        }
        
        return sb.toString();
    }
    
    
    private void appendCompressedString(StringBuilder sb, char c, int count){
        sb.append(count).append(c);
    }
}