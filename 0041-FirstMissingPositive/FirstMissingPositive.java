
class FirstMissingPositive {
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int i = 0;
            while(i < nums.length){
                int val = nums[i];
                if(val == i + 1){
                    i++;
                }
                else {
                    // non positive || > nums.length
                    if(val <= 0 || val > nums.length){
                        i++;
                    }
                    else {
                        // duplicate? 
                        if(nums[val - 1] == val){
                            i++;
                        }
                        else{
                            swap(nums, i, val - 1);
                        }
                    }
                }
            }
            
            for(int j = 0; j < nums.length; j++){
                if(nums[j] != j + 1) return j + 1;
            }
            
            return nums.length + 1;
        }
        
        private void swap (int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
