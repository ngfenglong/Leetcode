
class AliceAndBobPlayingFlowerGame {
    class Solution {
        public long flowerGame(int n, int m) {
            if(n+m < 3) return 0l;
            
            int evenN = n/2;
            int oddN = (n + 1) / 2;
            
            int evenM = m/2;
            int oddM = (m + 1) / 2;
            
            return ((long)evenN * oddM) + ((long)oddN * evenM);
            
        }
    }
}
