class Solution {
    final int MODULO = 1000000007;
    public int sumSubarrayMins(int[] arr) {
        int[] dp = new int[arr.length];
        
        Stack<Integer> smallestIdx = new Stack<Integer>();
        
        for(int i = 0; i < arr.length; i++){
            while(!smallestIdx.isEmpty() && arr[smallestIdx.peek()] >= arr[i]){
                smallestIdx.pop();
            }
            
            if(smallestIdx.isEmpty()){
                dp[i] = (i + 1) * arr[i];
            } else {
                int j = smallestIdx.peek();
                dp[i] = dp[j] + (i - j) * arr[i];
            }
            
            smallestIdx.push(i);
        } 
            
        long min = 0l;
        for(int i = 0; i < dp.length; i++){
            min += dp[i];
            min %= MODULO;
        }
        return (int)min;   
    }
}