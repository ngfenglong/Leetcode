import java.util.*;

class BitwiseXOROfAllPairings{
    class Solution {
        public int xorAllNums(int[] nums1, int[] nums2) {
            Map<Integer, Integer> hm = new HashMap<>();
    
            for(int i: nums1){
                hm.put(i, hm.getOrDefault(i, 0) + nums2.length);
            }
    
            for(int i : nums2) {
                hm.put(i, hm.getOrDefault(i, 0) + nums1.length);
            }
    
            int ans = 0;
            for(int key: hm.keySet()){
                if(hm.get(key) % 2 == 1){
                    ans ^= key;
                }
            }
    
            return ans;
        }
    }
}
