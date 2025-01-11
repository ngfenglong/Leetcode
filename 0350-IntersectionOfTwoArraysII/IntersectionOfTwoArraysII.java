import java.util.*;

class IntersectionOfTwoArraysII {
    
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            HashMap<Integer, Integer> hm = new HashMap<>();
            
            for(int i= 0 ; i < nums1.length; i++){
                hm.put(nums1[i], hm.getOrDefault(nums1[i], 0) + 1);
            }
            
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < nums2.length; i++){
                if(hm.containsKey(nums2[i])){
                    if(hm.get(nums2[i]) == 1) hm.remove(nums2[i]);
                    else hm.put(nums2[i], hm.get(nums2[i]) - 1);
                    
                    list.add(nums2[i]);
                }
            }
            
            int[] ans = new int[list.size()];
            for(int i = 0 ; i < ans.length; i++){
                ans[i] = list.get(i);
            }
            
            return ans;
        }
    }
}
