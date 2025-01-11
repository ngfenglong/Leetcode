
class LongestPalindromicSubstring {
    class Solution {
        public String longestPalindrome(String s) {
            String ans = "";
            for(int i = 0; i < s.length(); i++){
                String s1 = checkPalindromeLength(s, i, i);
                String s2 = checkPalindromeLength(s, i - 1, i);
                
                if(s1.length() > ans.length()) ans = s1;
                if(s2.length() > ans.length()) ans = s2;
            }
            return ans;
        }
        
        private String checkPalindromeLength(String s, int left, int right){
            while(left >= 0 && right < s.length() && s.charAt(right) == s.charAt(left)) {
                left--;
                right++;
            }
            
            return s.substring(left + 1, right);
        }
    }
    
    
}
