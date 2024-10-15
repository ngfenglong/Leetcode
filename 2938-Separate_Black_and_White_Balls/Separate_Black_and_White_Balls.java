class Solution {
    public long minimumSteps(String s) {
        long ans = 0l;
        int blackBalls = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                ans += (long)blackBalls;
            }
            else {
                blackBalls++;
            }
        }
    
        return ans;  
    }
}