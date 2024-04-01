class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] check = new int[n+1];
        
        for(int i: citations){
            check[Math.min(n, i)]++;
        }
        
        int cumm = 0;
        for(int i = n; i >= 0; i--){
            cumm += check[i];
            if(cumm >= i) return i;
        }
        
        return 0;
    }
}