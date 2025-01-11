
class FindTheDuplicateNumber {
    class Solution {
        public int findDuplicate(int[] nums) {
            int i = 0;
            while(i < nums.length){
                int val = nums[i];
                int pos = nums[i] - 1;
                if(nums[pos] == val){
                    if(i == pos) i++;
                    else return val;
                } 
                else {
                    swap(nums, i, pos);
                }
            }
            return -1;
        }
        
        private void swap(int[] arr, int i, int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
