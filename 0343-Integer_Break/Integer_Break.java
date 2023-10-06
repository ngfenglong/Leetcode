class Solution {
    HashMap<Integer,Integer> maxProduct = new HashMap<>();
    
    public int integerBreak(int n) {
        int max = 0;
        for(int i = 2; i <= n; i++){
            max = getLargestProduct(i);
        }
        return max;        
    }
    
    private int getLargestProduct(int n){
        if(n <= 2) return 1;
        if(maxProduct.containsKey(n)) return maxProduct.get(n);
        
        int currMax = 0;
        for(int i = 1; i <= n/2; i++){
            // 2 things to be checked - Stop breaking it further, breaking it further
            currMax = Math.max(currMax, i * getLargestProduct(n - i));
            currMax = Math.max(currMax, i * (n - i));
        }
        
        maxProduct.put(n, currMax);
        return currMax;
    }
}