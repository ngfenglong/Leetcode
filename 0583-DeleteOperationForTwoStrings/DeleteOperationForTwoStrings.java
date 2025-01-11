
class DeleteOperationForTwoStrings {
    class Solution {
        Integer[][] dp;
        public int minDistance(String word1, String word2) {
            dp = new Integer[word1.length()][word2.length()];
            
            return dfs(word1, word2, 0, 0);
            
        }
        
        private int dfs(String word1, String word2, int p1, int p2){
            if(p1 >= word1.length()) return word2.length() - p2;
            if(p2 >= word2.length()) return word1.length() - p1;
                
            if(dp[p1][p2] != null) return dp[p1][p2];
            
            if(word1.charAt(p1) == word2.charAt(p2)){
                return dfs(word1, word2, p1+1, p2+1);
            }
            
            int deleteFromFirst = dfs(word1, word2, p1 + 1, p2) + 1;
            int deleteFromSecond = dfs(word1, word2, p1, p2 + 1) + 1;
            
            int least = Math.min(deleteFromFirst, deleteFromSecond);
            
            // memoization
            dp[p1][p2] = least;
            return least;
        }
    }
    
            // each time the 2 characters are different -> Either delete from word1/ word2  --> 2path
            // if 2 characters are the same, both p1 & p2 => + 1 
            
            // escape condition: 
                // if p1 >= word1.length() && p2 >= word2.length -> Both ended, return 0
                // if p1 >= word1.length && && p2 < word2.length (or vice versa), return the remaining length
            
}
