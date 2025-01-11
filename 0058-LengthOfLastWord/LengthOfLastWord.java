
class LengthOfLastWord {
    class Solution {
        public int lengthOfLastWord(String s) {
            int firstChar = s.length()-1;
            while(firstChar >= 0 && s.charAt(firstChar) == ' '){
                firstChar--;
            }
            
            int ans = 0;
            while(firstChar >= 0 && s.charAt(firstChar) != ' '){
                ans++;
                firstChar--;
            }
            
            return ans;
        }
    }
}
