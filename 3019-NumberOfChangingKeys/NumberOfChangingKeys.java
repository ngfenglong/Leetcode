
class NumberOfChangingKeys {
    class Solution {
        public int countKeyChanges(String s) {
            int prev = convertCharToInt(s.charAt(0));
            int count = 0;
            for(int i = 1; i < s.length(); i++) {
                int curr = convertCharToInt(s.charAt(i));
                if(prev != curr){
                    count++;
                }
                prev = curr;
            }
            return count;
        }
        
        private int convertCharToInt(char c){
            if (c >= 'a' && c <= 'z'){
                return c - 'a';
            }
            else {
                return c - 'A';
            }
        }
    }
}
