class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> occurHM = new HashMap<Integer, Integer>();
        
        for(int i: nums){
            occurHM.put(i, occurHM.getOrDefault(i,0) + 1);
        }
        
        int totalOperations = 0; 
        for(int occur: occurHM.values()){
            if(occur == 1) return -1;
            
            totalOperations += Math.ceil((double)occur / 3);
        }
        
        return totalOperations;
    }
}