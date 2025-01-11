
class PowerOfFour {
    class Solution {
        public boolean isPowerOfFour(int n) {
            while(n > 1){
                if(((n >> 2) << 2) != n) return false;
                n = n >> 2;
            }
            
            
            return n == 1;
        }
    }
}
