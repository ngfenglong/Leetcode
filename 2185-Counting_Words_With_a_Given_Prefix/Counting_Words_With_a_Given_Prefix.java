class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;

        for(String word: words){
            if(isPref(pref, word)) count++;
        }

        return count;
    }

    private boolean isPref(String pref, String word){
        if(pref.length() > word.length()) return false;

        for(int i = 0 ; i < pref.length(); i++){
            if(pref.charAt(i) != word.charAt(i)) return false;
        }

        return true;
    }
}