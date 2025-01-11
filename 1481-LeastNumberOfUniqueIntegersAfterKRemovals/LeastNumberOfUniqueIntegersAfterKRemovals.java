import java.util.*;

class LeastNumberOfUniqueIntegersAfterKRemovals {
    
    class Solution {
        public int findLeastNumOfUniqueInts(int[] arr, int k) {
            HashMap<Integer, Integer> hm = new HashMap<>();
            
            for(int i = 0; i < arr.length; i++){
                hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
            }
            
            
            int[] frequencies = new int[arr.length + 1];
            for(Integer freq: hm.values()){
                frequencies[freq]++;
            }
            
            int ans = hm.size();
            for(int i = 1; i < frequencies.length; i++){
                while(frequencies[i] > 0) {
                    if(k >= i) {
                        k -= i;
                        frequencies[i]--;
                        ans --;
                    }
                    else {
                        return ans;
                    }
                }
            }
            
            return ans;
            
        }   
    }
}
