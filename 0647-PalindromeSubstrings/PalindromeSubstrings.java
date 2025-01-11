
class PalindromeSubstrings {
    class Solution {
        int count = 0;
        public int countSubstrings(String s) {
            for(int i = 0; i < s.length(); i++){
                checkPalindrome(s, i, i);
                checkPalindrome(s, i, i + 1);
            }
            return count;
        }
        
        private void checkPalindrome(String s, int left, int right) {
            while(left >= 0 && right<= s.length() - 1 && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
                count++;
            }
        }
    }
}
