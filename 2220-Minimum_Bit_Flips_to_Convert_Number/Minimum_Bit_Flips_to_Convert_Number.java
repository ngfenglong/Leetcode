class Solution {
    public int minBitFlips(int start, int goal) {
        int xorValue = start ^ goal;
        
        int bits = 0;
        while(xorValue != 0){
            if(xorValue % 2 != 0) bits++;
            xorValue /= 2;
        }
        
        return bits;
    }
}