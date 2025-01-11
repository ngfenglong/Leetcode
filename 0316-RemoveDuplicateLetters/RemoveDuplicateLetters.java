
class RemoveDuplicateLetters {
    class Solution {
        public String removeDuplicateLetters(String s) {
            // get the list of duplicates & the index/ the number of dups
            
            int[] counts = new int[26];
            
            for(int i = 0; i < s.length(); i++){
                counts[s.charAt(i) - 'a']++;
            }
            
            int pos = 0;
            
            for(int i = 0; i < s.length(); i++){
                counts[s.charAt(i) - 'a']--;
                if(s.charAt(i) < s.charAt(pos)){
                    pos = i;
                } 
                if(counts[s.charAt(i) - 'a'] == 0) break;
            }
            
            return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll(""+ s.charAt(pos), ""));
            
            
        }
    }
}
