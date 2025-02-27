public class FindTheChildWhoHasTheBallAfterKSeconds {
    class Solution {
        public int numberOfChild(int n, int k) {
            int rounds = k / (n - 1);
            int lastRoundPasses = k % (n - 1);
    
            if(rounds % 2 == 0){
                return lastRoundPasses;
            }
            else {
                return n - 1 - lastRoundPasses;
            }
        }
    }
}