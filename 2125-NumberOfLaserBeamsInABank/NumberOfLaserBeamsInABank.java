
class NumberOfLaserBeamsInABank {
    class Solution {
        public int numberOfBeams(String[] bank) {
            int prev = 0;
            int ans = 0;
            
            for(int i = 0; i < bank.length; i++){
                int count = 0;
                String s = bank[i];
                for(int j = 0; j < s.length(); j++){
                    if(s.charAt(j) == '1') count++;
                }
                
                if(count > 0) {
                    ans += (count * prev);
                    prev = count;
                }
            }
            
            return ans;
        }
    }
}
