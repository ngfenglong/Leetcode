
class MinimumNumberOfOperationsToMoveAllBallsToEachBox {
    class Solution {
        public int[] minOperations(String boxes) {
            int n = boxes.length();
            int[] ans = new int[n];
    
            int[] fromLeft = new int[n];
            int[] fromRight = new int[n];
    
            
            int count = 0; 
            for (int i = 1; i < n; i++) {
                count += Character.getNumericValue(boxes.charAt(i - 1));
                fromLeft[i] = fromLeft[i - 1] + count;
            }
    
            
            count = 0; 
            for (int i = n - 2; i >= 0; i--) {
                count += Character.getNumericValue(boxes.charAt(i + 1));
                fromRight[i] = fromRight[i + 1] + count;
            }
    
            // Combine the results from both directions
            for (int i = 0; i < n; i++) {
                ans[i] = fromLeft[i] + fromRight[i];
            }
    
            return ans;
        }
    }
}
