class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // Traverse 2 index i, j
        // text[i] == text[j] -> count ++, i + 1, j + 1
        // if text[i] != text[j], 2 routes, i + 1 || j + 1
        
        // dp check visited, return value;
        
        Integer[][] dp = new Integer[text1.length()][text2.length()];
        return checkSequence(text1.toCharArray(), text2.toCharArray(), 0, 0, dp);
    }
    
    private int checkSequence(char[] text1, char[] text2, int i, int j, Integer[][] dp){
        if(i >= text1.length || j >= text2.length){
            return 0;
        }
        
        if(dp[i][j] != null) {
            return dp[i][j];
        }
        
        int count = 0;
        if(text1[i] == text2[j]) {
            count = checkSequence(text1, text2, i + 1, j + 1, dp) + 1;
        } else {
            count = Math.max(checkSequence(text1, text2, i + 1, j, dp), checkSequence(text1, text2, i, j + 1, dp));
        }
        
        dp[i][j] = count;
        return count;
        
    }
    
    
}