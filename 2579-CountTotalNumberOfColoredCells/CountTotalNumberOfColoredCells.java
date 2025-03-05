public class CountTotalNumberOfColoredCells {
    class Solution {
        public long coloredCells(int n) {
            long ans = 1;
    
            if(n == 1) return ans;
            
            for(int i = 2; i <= n; i++){
                ans = ans + ((i - 1) * 4);
            }
    
            return ans;
        }
    }
}