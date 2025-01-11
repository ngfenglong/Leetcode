
class MissingNumbers {
    class Solution {
        public int missingNumber(int[] nums) {
            boolean[] checkList = new boolean[nums.length + 1];
            for(int i = 0 ; i < nums.length; i++){
                checkList[nums[i]] = true;
            }
            
            for(int i = 0; i < checkList.length; i++){
                if(!checkList[i]) return i;
            }
            
            return -1;
        }
    }
}
