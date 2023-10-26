class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // Union - Find 
        int[] characters = new int[26];
        for(int i = 0; i < 26; i++){
            characters[i] = i;
        }

        for(int i = 0 ; i < s1.length(); i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if(characters[c1 - 'a'] < characters[c2 - 'a']){
                union(characters[c2 - 'a'], characters[c1 - 'a'], characters);
            }
            else{
                union(characters[c1 - 'a'], characters[c2 - 'a'], characters);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < baseStr.length(); i++){
            char c = (char) (characters[baseStr.charAt(i) - 'a'] + 'a');
            sb.append(c);
        }        

        return sb.toString();
    }


    private void union(int idx, int newValue, int[] characters){
        for(int i = 0; i < characters.length; i++){
            if(characters[i] == idx){
                characters[i] = newValue;
            }
        }
    }
}