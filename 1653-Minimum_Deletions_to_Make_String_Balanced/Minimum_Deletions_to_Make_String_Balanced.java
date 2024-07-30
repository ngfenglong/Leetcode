class Solution {
    public int minimumDeletions(String s) {
        int aCount = 0;
        int bCount = 0;
        int total = s.length();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a') aCount++;
        }
        
        int ans = aCount;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a') aCount--;
            if(s.charAt(i) == 'b') bCount++;
            ans = Math.min(ans, aCount + bCount);
        }
        
        return ans;
    }
}