
class FindTheStudentThatWillReplaceTheChalk {
    class Solution {
        public int chalkReplacer(int[] chalk, int k) {
            int sumOfOneRound = 0;
            for(int i = 0; i < chalk.length; i++){
                sumOfOneRound += chalk[i];
                if(k < sumOfOneRound) return i;
            }
            
            if(k % sumOfOneRound == 0) return 0;
            
            int rounds = k / sumOfOneRound;
            int curr = rounds * sumOfOneRound;
            
            for(int i = 0; i < chalk.length; i++){
                curr += chalk[i];
                if(k < curr) return i;
            }
            
            return -1;
        }
    }
}
