
class MergeOperationsToTurnArrayIntoAPalindromeArray {
    class Solution {
        public int minimumOperations(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            int operations = 0;
            int leftValue = nums[left];
            int rightValue = nums[right];
                
            while(left < right){
                if(leftValue == rightValue){
                    leftValue = nums[++left];
                    rightValue = nums[--right];
                }
                else if(leftValue < rightValue){
                    leftValue += nums[++left];
                    operations++;
                }
                else {
                    rightValue += nums[--right];
                    operations++;
                }
            }
            
            return operations;
        }
    }
}
