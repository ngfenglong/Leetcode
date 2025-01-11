
class FindMissingObservations {
    class Solution {
        public int[] missingRolls(int[] rolls, int mean, int n) {
            int m = rolls.length;
            int mTotalValue = 0;
            for(int r: rolls){
                mTotalValue += r;
            }
            
            int totalRolls = m + n;
            int totalValue = totalRolls * mean;
            int nTotalValue = totalValue - mTotalValue;
            
            if(nTotalValue < n || nTotalValue > (n * 6)) return new int[]{};
            
            int[] ans = new int[n];
            int noOfUneven = nTotalValue % n;
            int avgN = nTotalValue / n;     
        
            for(int i = 0; i < n; i++){
                ans[i] = avgN;
                if(noOfUneven > 0) {
                    ans[i]++;
                    noOfUneven--;
                }
            }
            
            return ans;
        }
    }
}
