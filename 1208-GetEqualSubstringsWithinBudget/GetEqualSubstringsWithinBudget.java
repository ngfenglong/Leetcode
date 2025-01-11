
class GetEqualSubstringsWithinBudget {
    class Solution {
        public int equalSubstring(String s, String t, int maxCost) {
            int[] diff = new int[s.length()];
            
            
            for(int i = 0; i < s.length(); i++){
                diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
            }
            
            int maxLen = 0;
            int p1 = 0;
            int p2 = 0;
            int currCost = 0;
            while(p2 < s.length()){
                currCost += diff[p2];
                while(currCost > maxCost){
                    currCost -= diff[p1++];
                }
                
                maxLen = Math.max(maxLen, p2 - p1 + 1);
                p2++;
            }
            
            return maxLen;
        }
    }
}
