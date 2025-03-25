import java.util.*;

public class NextGreaterElementI {
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            HashMap<Integer, Integer> hm = new HashMap<>();
            Stack<Integer> stack = new Stack<>();
    
            for(int i = 0; i < nums2.length; i++){
                while(!stack.isEmpty() &&  nums2[i] > stack.peek()){
                    hm.put(stack.pop(), nums2[i]);
                }
    
                stack.push(nums2[i]);
            }
    
            while(!stack.isEmpty()){
                hm.put(stack.pop(), -1);
            }
    
            int[] ans = new int[nums1.length];
            for(int i = 0; i < nums1.length; i++){
                ans[i] = hm.get(nums1[i]);
            }
    
            return ans;
        }
    }
}