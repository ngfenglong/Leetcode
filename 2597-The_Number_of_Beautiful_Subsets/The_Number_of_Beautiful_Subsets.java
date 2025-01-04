import java.util.*;


class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        return countBeautifulSubsets(nums, k, 0, new ArrayList<>());
    }
    
    private int countBeautifulSubsets(int[] nums, int k, int index, List<Integer> currentSubset) {
        if (index == nums.length) {
            if (currentSubset.isEmpty()) {
                return 0;
            }
            for (int i = 0; i < currentSubset.size(); i++) {
                for (int j = i + 1; j < currentSubset.size(); j++) {
                    if (Math.abs(currentSubset.get(i) - currentSubset.get(j)) == k) {
                        return 0;
                    }
                }
            }
            return 1;
        }
        
        int count = 0;
        
        // Include the current element
        currentSubset.add(nums[index]);
        count += countBeautifulSubsets(nums, k, index + 1, currentSubset);
        
        // Exclude the current element
        currentSubset.remove(currentSubset.size() - 1);
        count += countBeautifulSubsets(nums, k, index + 1, currentSubset);
        
        return count;
    }
}
