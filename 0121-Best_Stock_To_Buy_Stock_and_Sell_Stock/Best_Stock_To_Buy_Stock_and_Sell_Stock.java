class Solution {
    public int maxProfit(int[] prices) {
        int smallestBuying = prices[0];
        
        int maxProfit = 0;
        
        for(int i = 0 ; i < prices.length; i++){
            maxProfit = Math.max(prices[i] - smallestBuying, maxProfit);
            smallestBuying = Math.min(smallestBuying, prices[i]);
        }
        
        return maxProfit;
    }
}