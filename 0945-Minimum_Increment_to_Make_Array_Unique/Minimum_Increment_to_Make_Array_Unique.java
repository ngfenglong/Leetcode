class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);

        int total = 0;
        int count = 0;

        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] == nums[i]) count++;
            else{
                int diff = nums[i] - nums[i - 1];
                
                while(count > 0 && diff > 1){
                        total += count;
                        count--;
                        diff--;
                }                        
                total += count;
            }
        }
        
        while(count > 0) {
            total += count;
            count--;
        }
                
        return total;
    }
}