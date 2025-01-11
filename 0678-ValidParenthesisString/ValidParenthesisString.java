
class ValidParenthesisString {
    class Solution {
        public boolean checkValidString(String s) {
            char[] arr = s.toCharArray();
            int n = arr.length;
            return checkValidity(arr, 0, 0, new Boolean[n + 1][n + 1]);
        }
        
        private boolean checkValidity(char[] arr, int idx, int openBracket, Boolean[][] dp){
            if(idx == arr.length) return openBracket == 0;
            
            if(dp[idx][openBracket] != null) return dp[idx][openBracket];
            boolean check = false;
            if(arr[idx] == ')'){
                if(openBracket == 0) {
                    dp[idx][openBracket] = false;
                    return false;   
                }
                check = checkValidity(arr, idx + 1, openBracket - 1, dp);
            } 
            if(arr[idx] == '(') {
                check = checkValidity(arr, idx + 1, openBracket + 1, dp);
            }
            if(arr[idx] == '*'){
                if(openBracket > 0){
                    check = checkValidity(arr, idx + 1, openBracket - 1, dp);
                }
                if(!check){
                    check = checkValidity(arr, idx + 1, openBracket, dp);
                    check = check || checkValidity(arr, idx + 1, openBracket + 1, dp);
                } 
            }
            
            dp[idx][openBracket] = check;
            return check;
        }
    }
}
