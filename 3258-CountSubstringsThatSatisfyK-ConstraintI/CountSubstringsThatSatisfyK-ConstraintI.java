
class CountSubstringsThatSatisfyK-ConstraintI {
    class Solution {
        public int countKConstraintSubstrings(String s, int k) {
            int i = 0;
            int ones = 0;
            int zeros = 0;
            int start = 0;
            int ans = 0;
            
            while(i < s.length()){
                if(s.charAt(i) == '1') ones++;
                if(s.charAt(i) == '0') zeros++;
                
                while(ones > k && zeros > k){
                    if(s.charAt(start) == '0') zeros--;
                    if(s.charAt(start) == '1') ones--;
                    
                    start++;
                }
                
                ans += (i - start + 1);
                i++;
            }
            
            return ans;
        }
    }
}
