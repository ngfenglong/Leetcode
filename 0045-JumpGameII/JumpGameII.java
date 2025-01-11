
class JumpGameII {
    class Solution {
        public int jump(int[] nums) {
            int max = 0;// To keep track which is the longest of the current step
            int currentIdx = 0; // Keep track which idx can give you the longest jump
            int count = 0;
            while(currentIdx < nums.length - 1){ // Once u hit num.length - 1 index, you have reached the destination
                max = 0; // Restart max
                int newIdx = currentIdx; // To find the next place to hope to, one that can give u the longest jump
                if(currentIdx +  nums[currentIdx] >= nums.length -1) return count + 1;
                for(int i = 1; i <= nums[currentIdx]; i++){
                    if(max < currentIdx + i + nums[currentIdx + i]){
                        max = currentIdx + i + nums[currentIdx + i];
                        newIdx = currentIdx + i;
                    }
                }
                
                currentIdx = newIdx;
                count++;
            }
            return count;
        }
    }
}
