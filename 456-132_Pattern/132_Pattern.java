class Solution {
    public boolean find132pattern(int[] nums) {
        // keep an arr of min to keep track of the min at that index
        // keep a stack to num that is > min[i] but not bigger than element i 
        int[] min = new int[nums.length];
        Stack<Integer> possibleMid = new Stack<Integer>();
        
        min[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            min[i] = Math.min(min[i-1],nums[i]);
        }
        
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] > min[i]){
                while(!possibleMid.isEmpty() && possibleMid.peek() <= min[i]){
                    possibleMid.pop();
                }
                if(!possibleMid.isEmpty() && possibleMid.peek() < nums[i]) return true;
                
                possibleMid.push(nums[i]);
            }
        }
        
        return false;
    }
}