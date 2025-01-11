
class RansomNote {
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] letters = new int[26];
            for(int j = 0; j < magazine.length(); j++){
                int c = magazine.charAt(j) - 'a';
                letters[c]++;
            }
            
            for(int i = 0; i < ransomNote.length(); i++){
                int c = ransomNote.charAt(i) - 'a';
                if(letters[c] == 0) return false;
                letters[c]--;
            }
            
            return true;
        }
    }
}
