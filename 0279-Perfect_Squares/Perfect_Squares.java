class Solution {
    public int numSquares(int n) {
        int[] arr = new int[n + 1];
        
        for(int i = 1; i <= n; i++){
            int least = Integer.MAX_VALUE;
            for(int j = 1; (j * j) <= i; j++){
                least = Math.min(least, arr[i - (j*j)] + 1);
            }
            arr[i] = least;
        }
        
        return arr[n];
    }
}