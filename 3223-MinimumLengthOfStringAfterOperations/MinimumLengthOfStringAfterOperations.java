class MinimumLengthOfStringAfterOperations{
    class Solution {
        public int minimumLength(String s) {
            int[] freq = new int[26];
            for(int i = 0; i < s.length(); i++){
                int idx = s.charAt(i) - 'a';
                freq[idx]++;
            }
    
            int count = 0;
            for(int i = 0; i < freq.length; i++){
                if(freq[i] > 0){
                    if(freq[i] % 2 == 0) count += 2;
                    else count++;
                }
            }
    
            return count;
        }
    }
}
