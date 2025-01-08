class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = i + 1; j < words.length; j++){
                if(isPrefixAndSuffix(words[i], words[j])) count++;
            }
        }

        return count;
    }

    private boolean isPrefixAndSuffix(String toCheck, String word){
        if(toCheck.length() > word.length()) return false;

        int i = 0;        
        int toCheckLen = toCheck.length();
        int wordLen = word.length();

        while(i < toCheckLen){
            if(toCheck.charAt(i) != word.charAt(i)) return false;
            if(toCheck.charAt(toCheckLen - i -1) != word.charAt(wordLen - i -1)) return false;

            i++;
        }

        return true;
    } 
}