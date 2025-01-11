import java.util.*;

class BagOfTokens {
    class Solution {
        public int bagOfTokensScore(int[] tokens, int power) {
            if(tokens.length == 0) return 0;
            
            Arrays.sort(tokens);
            int left = 0;
            int right = tokens.length - 1;
            int score = 0;
            
            while(left < tokens.length && power >= tokens[left]) {
                power -= tokens[left++];
                score++;
            }
            
            
            while(left < right && score > 0){
                power += tokens[right];
                score--;
                while(left < right && power >= tokens[left]){
                    score++;
                    power -= tokens[left++];
                }
                right--;
            }
            
            return score;
        }
    }
}
