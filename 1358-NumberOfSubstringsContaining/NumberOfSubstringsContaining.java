public class NumberOfSubstringsContaining {
    class Solution {
        public int numberOfSubstrings(String s) {
            int start = 0;
            int[] freq = new int[3];
    
            int ans = 0;
            
            // [a,a,b,c,b,c]
            for(int end = 0; end < s.length(); end++){
                int letter = s.charAt(end) - 'a';
                freq[letter]++;
    
                if(freq[0] > 0 && freq[1] > 0 && freq[2] > 0){
                    int currLetter = s.charAt(start) - 'a';
                    while(start < end && freq[currLetter] > 1){
                        ans += (s.length() - end);
                        freq[currLetter]--;                    
                        currLetter = s.charAt(++start) - 'a';
                    }
    
                    ans += (s.length() - end);
                    freq[currLetter]--;
                    start++;
                }
            }
    
            return ans;
        }
    }
}