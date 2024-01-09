class Solution {
    public String decodeString(String s) {
        Stack<Integer> multiples = new Stack<>();
        Stack<String> words = new Stack<>();
        
        int i = 0;
        char[] charArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        while (i < charArr.length) {
            // is number
            if(isDigit(charArr[i])){
                int m = charArr[i] - '0';
                while(isDigit(charArr[i + 1])){
                    m = (m * 10) + (charArr[++i] - '0');
                }
                
                multiples.push(m);
            }
            
            else if(charArr[i] == '[') {
                // store the existing SB into stack
                words.push(sb.toString());
                sb = new StringBuilder();
            } 
            
            else if(charArr[i] == ']') {
                int m = multiples.pop();
                String tempStr = sb.toString();
                for(int j = 1; j < m; j++){
                    sb.append(tempStr);
                }
                StringBuilder tempSB = new StringBuilder();
                tempSB.append(words.pop());
                tempSB.append(sb.toString());
                sb = tempSB;
            }
            // is alphabet
            else{
                sb.append(charArr[i]);
            }
            i++; 
        }
        
        return sb.toString();
    }
    
    private boolean isDigit(char c){
        return c >= '0' && c <= '9';
    }
}