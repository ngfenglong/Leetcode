
class SortArrayByParity {
    class Solution {
        public int[] sortArrayByParity(int[] nums) {
            int[] newArr = new int[nums.length];
            
            int left = 0;
            int right = nums.length - 1;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] % 2 == 1){
                    newArr[right--] = nums[i];  
                } else{
                    newArr[left++] = nums[i];
                }
            }
            
            return newArr;
        }
    }
}
