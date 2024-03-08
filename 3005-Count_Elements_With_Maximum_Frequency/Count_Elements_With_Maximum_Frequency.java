class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        
        int maxFreq = 0;
        for(int i: nums){
            freq[i]++;
            maxFreq = Math.max(maxFreq, freq[i]);
        }

        int total = 0;
        for(int i = 0; i < freq.length; i++){
            if(freq[i] == maxFreq) {
                total += maxFreq;
            }
        }
        
        return total;
    }
}