
class FinalPricesWithASpecialDiscountInAShop {
    class Solution {
        public int[] finalPrices(int[] prices) {
            int n = prices.length;
            int[] ans = new int[n];
            
            ans[n-1] = prices[n-1];
            
            for(int i = n - 2; i >= 0; i--){
                ans[i] = prices[i];
                
                int j = i + 1;
                while(j < n && prices[j] > prices[i]) j++;
                
                if(j < n) ans[i] -= prices[j];
            }
            
            return ans;
        }
    }
}
