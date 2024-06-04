class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        
        char[] letters = s.toCharArray();
        
        for(int i = 0; i < letters.length; i++){
            hm.put(letters[i], hm.getOrDefault(letters[i],0) + 1);
        }
        
        boolean hasOdd = false;
        int total = 0;
        for(Character c : hm.keySet()){
            if(hm.get(c) % 2 == 1){
                hasOdd = true;
                total += hm.get(c) - 1;
            }
            else {
                total += hm.get(c);
            }
        }
        
        return hasOdd ? total + 1: total;
    }
}