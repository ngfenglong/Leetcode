class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        int[] ans = new int[n];
        boolean skip = false;
        int deckIdx = 0;
        int resultIdx = 0;
        
        while(deckIdx < n){
            if(ans[resultIdx] == 0){
                if(!skip){
                    ans[resultIdx] = deck[deckIdx];
                    deckIdx++;
                }
                skip = !skip;
            }
            resultIdx = (resultIdx + 1) % n;
        }
        return ans;
        
    }
}