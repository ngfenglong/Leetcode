class Solution {
    public int minOperations(int[] nums, int k) {
        int finalXor = 0;
        for(int num: nums){
            finalXor = finalXor ^ num;
        }
        
        int count = 0;
        while(k > 0 || finalXor > 0){
            if(k == finalXor) return count;
            
            if((k % 2) != (finalXor % 2)) count++;
            
            k /= 2;
            finalXor /=2;
        }
        
        return count;
    }
}