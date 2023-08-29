class Solution {
    public int bestClosingTime(String customers) {
        int[] closePenalties = new int[customers.length() + 2];
        int[] openPenalties = new int[customers.length() + 2];
        
        int[] ans = new int[customers.length() + 2];
        
        
        for(int i = customers.length(); i >= 1; i--){
            int closePenalty = customers.charAt(i - 1) == 'Y' ? 1 : 0;
            closePenalties[i] = closePenalties[i+1] + closePenalty; 
            
        }
        
        for(int i = 1; i <= customers.length(); i++){
            int openPenalty = customers.charAt(i - 1) == 'N' ? 1 : 0;
            openPenalties[i] = openPenalties[i-1] + openPenalty;
        }
        
        int idx = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= customers.length() + 1; i++){
            ans[i] = closePenalties[i] + openPenalties[i -1];
            if(ans[i] < min) {
                min = ans[i];
                idx = i;
            }
        }
        
        return idx-1;
        
    }
}