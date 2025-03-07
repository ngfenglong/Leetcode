import java.util.*;

public class ContiguousArray {
    class Solution {
        public int findMaxLength(int[] nums) {
            HashMap<Integer, Integer> differences = new HashMap<>(); // store the earliest idx that has the difference for max diff
            differences.put(0, -1);
    
            int count = 0; 
            int max = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == 0) count--;
                else count++;
    
                if(differences.containsKey(count)){
                    max = Math.max(max, i - differences.get(count));
                }
                else {
                    differences.put(count, i);
                }
            }
    
            return max;
        }
    }
}