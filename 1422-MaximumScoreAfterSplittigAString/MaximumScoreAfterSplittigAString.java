
class MaximumScoreAfterSplittigAString {
    class Solution {
        public int maxScore(String s) {
            int numOfOnes = 0;
            for(int i = 1; i < s.length(); i++){
                if(s.charAt(i) == '1') numOfOnes++;
            }
            
            int currScore = numOfOnes;
            if(s.charAt(0) == '0') currScore++;
            
            int maxScore = currScore; 
            for(int i = 1; i < s.length() - 1; i++){
                if(s.charAt(i) == '0') currScore++;
                else currScore--;
                
                maxScore = Math.max(maxScore, currScore);
            }
            
            return maxScore;
        }
    }
}
