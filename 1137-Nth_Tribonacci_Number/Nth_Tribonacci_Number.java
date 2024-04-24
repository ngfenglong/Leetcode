class Solution {
    public int tribonacci(int n) {
        int n0 = 0;
        int n1 = 1;
        int n2 = 1;
        
        if(n == 0) return n0;
        if(n < 3) return n2;
        
        
        for(int i = 2; i < n; i++){
            int temp = n0 + n1 + n2;
            n0 = n1;
            n1 = n2;
            n2 = temp;
        }
        
        return n2;
   }
}