import java.util.*;
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> ans = new HashSet<>();
        int n = nums.length;
        int i = 0;
        while(i < n){
            if(nums[i] == i + 1){
                i++;
            }
            else {
                int val = nums[i];
                if(nums[val - 1] == val){
                    ans.add(val);
                    i++;
                }
                else {
                    swap(nums, i, val - 1);
                }
            }
        }
        return new ArrayList<>(ans);
    }
    
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}