
class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {
    class Solution {
        public int isPrefixOfWord(String sentence, String searchWord) {
            String[] words = sentence.split(" ");
            
            for(int i = 0; i < words.length; i++){
                if(containPrefix(words[i], searchWord)) return i + 1;
            }
            
            return -1;
        }
        
        private boolean containPrefix(String word, String searchWord){
            if(searchWord.length() > word.length()) return false;
            
            for(int i = 0; i < searchWord.length(); i++){
                if(word.charAt(i) != searchWord.charAt(i)) return false;
            }
            
            return true;
            
        }
    }
}
