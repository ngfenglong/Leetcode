
class Sqrt(x) {
    class Solution {
        public int mySqrt(int x) {
            if(x == 0) return 0;
            if(x < 4) return 1;
            
            int left = 1;
            int right = x;
            
            while(left <= right){
                int mid = left + (right - left)/2;
                if((long)mid * mid == x) return mid;
                else if((long)mid*mid > x)  right = mid - 1;
                else left = mid + 1;
            }
                
            return right;
        }
    }
}
