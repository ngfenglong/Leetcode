import java.util.*;

class MagneticForceBetweenTwoBalls {
    
    class Solution {
        public int maxDistance(int[] position, int m) {
            int max = 0;
            Arrays.sort(position);
            
            int right = position[position.length - 1];
            int left = 1;
            
            while(left <= right){
                int mid = left + (right - left)/2;
                
                if(canPass(mid, m, position)){
                    max = Math.max(max, mid);
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
            
            return max;
        }
        
        private boolean canPass(int space, int m, int[] position){
            int prev = 0;
            int curr = 1;
            m--;
            
            while(m > 0){
                if(curr >= position.length) return false;
                    
                if(position[curr] - position[prev] >= space){
                    prev = curr;
                    m--;    
                }
                
                curr++;
            }
            
            return true;
        }
    }
}
