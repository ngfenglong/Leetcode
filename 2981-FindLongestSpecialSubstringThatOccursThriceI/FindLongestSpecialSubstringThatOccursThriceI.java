
class FindLongestSpecialSubstringThatOccursThriceI {
    class Solution {
        public int maximumLength(String s) {
            int[][] specialCount = new int[26][s.length() + 1];
            
            int prev = -1;
            int count = 0;
            for(int i = 0 ; i < s.length(); i++){
                int curr = s.charAt(i) - 'a';
                if(prev != curr) count = 0;
                
                count++;
                
                for(int j = 0; j < count; j++){
                    specialCount[curr][j]++;
                }
                
                prev = curr;
            }
            
            int longest = -1;
            
            for(int i = 0; i < 26; i++){
                for(int j = 0; j < specialCount[i].length; j++){
                    if(specialCount[i][j] == 0) break;
                    if(specialCount[i][j] >= 3 && j >= longest) {
                        longest = j + 1;  
                    } 
                }
            }
            
            return longest;
        }
    }
}
