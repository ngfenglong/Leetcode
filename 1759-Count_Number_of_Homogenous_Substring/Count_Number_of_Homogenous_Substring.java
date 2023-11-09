class Solution {
    public int countHomogenous(String s) {
        char c = s.charAt(0);
        int count = 0;
        long totalCount = 0l;
        
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c) {
                count++;
            }
            else {
                count = 1;
                c = s.charAt(i);
            }
            totalCount += (long)count;
        }
        
        return (int)(totalCount % 1000000007);
    }
}