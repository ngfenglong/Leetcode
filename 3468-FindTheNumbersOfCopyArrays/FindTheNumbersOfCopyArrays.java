public class FindTheNumbersOfCopyArrays {
    class Solution {
        public int countArrays(int[] original, int[][] bounds) {
            // Store an array of the differences between original[0] and other original element
    
            // using bounds[0][0], bounds[0][1] as the base starting point --> Traverse through the bound to check if 
            // adding difference[i] is within the range. if not maxCount = Math.min(maxCount, the availableCount) and update the range            
            int n = original.length;
            int[] differences = new int[n];
    
            for(int i = 1; i < n; i++){
                differences[i] = original[i] - original[0];
            }
            
            int baseLowerB = bounds[0][0];
            int baseUpperB = bounds[0][1];
            int maxCount = baseUpperB - baseLowerB + 1;
    
            for(int i = 1 ; i < n; i++){
                int lower = bounds[i][0];
                int upper = bounds[i][1];
    
                if(lower > (baseLowerB + differences[i])){
                    baseLowerB += (lower - (baseLowerB + differences[i]));
                }
                if(upper < (baseUpperB + differences[i])){
                    baseUpperB -= ((baseUpperB + differences[i]) - upper);
                }
            
                int localCount = (baseUpperB - baseLowerB + 1); // - missingUpper - missingLower;
                if(localCount < 0) localCount = 0;
    
                maxCount = Math.min(localCount, maxCount);
            }
            return maxCount;
        }
    }    
}