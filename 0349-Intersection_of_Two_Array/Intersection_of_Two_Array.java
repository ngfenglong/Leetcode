import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> seen = new HashSet<>();
        for(int i = 0; i < nums1.length; i++){
            seen.add(nums1[i]);
        }
        
        Set<Integer> intersect = new HashSet<>();
        for(int i = 0; i < nums2.length; i++){
            if(seen.contains(nums2[i])){
                intersect.add(nums2[i]);
            }
        }
        
        int[] ans = new int[intersect.size()];
        int i = 0;
        for(Integer num : intersect){
            ans[i++] = num;
        }
        
        return ans;
    }
}