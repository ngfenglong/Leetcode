class Solution {
    public char findTheDifference(String s, String t) {
        int[] numOfChars = new int[26];
        
        for(int i = 0 ; i < s.length(); i++){
            numOfChars[s.charAt(i) - 'a']++;
        }
        
        for(int i = 0 ; i < t.length(); i++){
            if(numOfChars[t.charAt(i) - 'a'] == 0){
                return t.charAt(i);
            }
            
            numOfChars[t.charAt(i) - 'a']--;
        }
        
        return 'a';
    }
}