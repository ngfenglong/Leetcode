class Solution {
    public String sortVowels(String s) {
        int[] vowels = new int[10];
        Set<Character> vowelSet = new HashSet<>();
        HashMap<Integer, Character> intToChar = new HashMap<>();
        HashMap<Character, Integer> charToInt = new HashMap<>();
        
        setupVowels(vowelSet, intToChar, charToInt);
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(vowelSet.contains(c)){
                int idx = charToInt.get(c);
                vowels[idx]++;
            }
        }
        
        
        int currIdx = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(vowelSet.contains(c)){
                while(vowels[currIdx] == 0){
                    currIdx++;
                }
                vowels[currIdx]--;
                sb.append(intToChar.get(currIdx));
            }
            else{
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
    
    private void setupVowels(Set<Character> set, HashMap<Integer, Character> intToChar, HashMap<Character, Integer> charToInt ){
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        
        charToInt.put('A',0);
        charToInt.put('E',1);
        charToInt.put('I',2);
        charToInt.put('O',3);
        charToInt.put('U',4);
        charToInt.put('a',5);
        charToInt.put('e',6);
        charToInt.put('i',7);
        charToInt.put('o',8);
        charToInt.put('u',9);
        
        intToChar.put(0,'A');
        intToChar.put(1,'E');
        intToChar.put(2,'I');
        intToChar.put(3,'O');
        intToChar.put(4,'U');
        intToChar.put(5,'a');
        intToChar.put(6,'e');
        intToChar.put(7,'i');
        intToChar.put(8,'o');
        intToChar.put(9,'u');
    }
}