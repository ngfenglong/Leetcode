import java.util.*;

class DegreeOfAnArray {
    class Solution {
        public int findShortestSubArray(int[] nums) {
            int maxDegree = 0;
            HashMap<Integer, List<Integer>> hm = new HashMap<>();
            
            for(int i = 0 ; i < nums.length; i++){
                if(!hm.containsKey(nums[i])) hm.put(nums[i], new ArrayList<>());
                hm.get(nums[i]).add(i);
                maxDegree = Math.max(maxDegree, hm.get(nums[i]).size());            
            }
            
            int shortestLength = Integer.MAX_VALUE;
            for(Integer key : hm.keySet()){
                if(hm.get(key).size() == maxDegree) {
                    List<Integer> list = hm.get(key);
                    int len = list.get(list.size() - 1) - list.get(0) + 1; 
                    shortestLength = Math.min(shortestLength, len);
                }
            }
            
            return shortestLength;
        }
    }
}
