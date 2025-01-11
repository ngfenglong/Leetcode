
class CountOddNumbersInAnIntervalRange {
    class Solution {
        public int countOdds(int low, int high) {
            if (low == high) return low % 2;
            if(high - low == 1) return 1;
            
            boolean bothOdd = (low % 2 == 1) && (high % 2 == 1);
            int addItself = bothOdd == true ? 1 : 0;
            
            double between  = Math.ceil(((double)high - low) / 2);
            return ((int)between + addItself);
        }
    }
}
