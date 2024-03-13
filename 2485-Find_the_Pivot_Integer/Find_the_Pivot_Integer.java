class Solution {
    public int pivotInteger(int n) {
        boolean isOdd = (n % 2 == 1);
        int total = (1 + n) * (n / 2);
        if(isOdd){
            total += ((1 + n) /2);
        }
            
        int cumulative = 0;
        for(int i = 1; i <= n; i++){
            cumulative += i;
            
            if(cumulative == total) return i;
            if(cumulative > total) return -1;
            total -= i;
        }
        
        return -1;
    }
}