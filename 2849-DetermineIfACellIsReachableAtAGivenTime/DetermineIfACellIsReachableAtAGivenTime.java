
class DetermineIfACellIsReachableAtAGivenTime {
    class Solution {
        public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
             if(sx == fx && sy == fy && t == 1) return false;
             return Math.abs(sx - fx) <= t && Math.abs(sy - fy) <= t;
            
        }
    }
}
