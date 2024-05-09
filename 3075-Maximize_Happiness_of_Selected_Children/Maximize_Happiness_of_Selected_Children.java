class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        Arrays.sort(happiness);
        
        int happinessDeducted = 0;        
        long ans = 0l;
        for(int i = n - 1; happinessDeducted < k; i--){
            if(happiness[i] - happinessDeducted > 0){
                ans += (long)(happiness[i] - happinessDeducted);
                happinessDeducted++;
            }
            else return ans;
        }
     
        return ans;
    }
}