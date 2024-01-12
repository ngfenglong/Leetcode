class Solution {
    public boolean halvesAreAlike(String s) {
        int count = 0;
        char[] charArr = s.toCharArray();
        for(int i = 0; i < charArr.length/2; i++){
            if(isVowel(charArr[i])) count++;    
        }
        
        for(int i = charArr.length/2; i < charArr.length; i++){
            if(isVowel(charArr[i])) count--;
        }
        
        return count == 0;
    }
    
    private boolean isVowel(char c){
        return c == 'a' || 
            c == 'e' ||
            c == 'i' ||
            c == 'o' ||
            c == 'u' ||
            c == 'A' ||
            c == 'E' ||
            c == 'I' ||
            c == 'O' ||
            c == 'U';
    }
}