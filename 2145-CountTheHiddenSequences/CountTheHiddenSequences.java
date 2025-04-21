public class CountTheHiddenSequences {
    class Solution {
        public int numberOfArrays(int[] differences, int lower, int upper) {
            int diff = upper - lower + 1;

            int lowerRange = 0;
            int upperRange = 0;
            int cumm = 0;

            for (int i = 0; i < differences.length; i++) {
                cumm += differences[i];
                lowerRange = Math.min(lowerRange, cumm);
                upperRange = Math.max(upperRange, cumm);

                if ((upperRange - lowerRange + 1) > diff)
                    return 0;
            }

            return (diff - (upperRange - lowerRange + 1)) + 1;
        }
    }

}