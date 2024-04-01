class Solution {
    public int hIndex(int[] citations) {
        int[] check = new int[1001];
        
        for(int i : citations){
            check[i]++;
        }
        
        int cumm = 0;
        for(int i = 1000; i >= 0; i--){
            cumm += check[i];
            if(cumm >= i) return i;
        }
        
        return 0;
    }
}