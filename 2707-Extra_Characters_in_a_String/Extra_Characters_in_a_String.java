import java.util.*;

class Solution {
    Set<String> dictSet = new HashSet<>();
    int minCharacters = Integer.MAX_VALUE;
    Integer[] memo;
    
    public int minExtraChar(String s, String[] dictionary) {
        memo = new Integer[s.length()];
        
        for(String word: dictionary){
            dictSet.add(word);
        }
        
        return checkExtra(s, 0);
    }
    
    private int checkExtra(String s, int i){
        if(i >= s.length()) return 0;
            
        if(memo[i] != null) return memo[i];
        
        int localMin = checkExtra(s, i + 1) + 1;
        for(int j = i + 1; j < s.length() + 1; j++){
            if(dictSet.contains(s.substring(i, j))) {
                localMin = Math.min(localMin, checkExtra(s, j));
            }
        }
                
        memo[i] = localMin;
        return localMin;
    }
}