class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int timeTaken = 0;
        int tixRequired = tickets[k];
        if(tixRequired == 1) return k + 1;
        
        for(int i = 0; i < tickets.length; i++){
            if(i <= k){
                timeTaken += Math.min(tickets[i], tixRequired);
            }
            else{
                timeTaken += Math.min(tickets[i], tixRequired - 1);
            }
        }
        
        return timeTaken;
    }
}