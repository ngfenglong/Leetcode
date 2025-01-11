
class BuyTwoChocolates {
    class Solution {
        public int buyChoco(int[] prices, int money) {
            int first = prices[0] < prices[1] ? prices[0] : prices[1];
            int second = prices[0] < prices[1] ? prices[1] : prices[0];
            
            for(int i = 2; i < prices.length; i++){
                if(prices[i] < first){
                    second = first;
                    first = prices[i];
                }
                else if(prices[i] < second){
                    second = prices[i];
                }
            }
            
            if((first + second) > money) return money;
            
            return money - (first + second);
        }
    }
}
