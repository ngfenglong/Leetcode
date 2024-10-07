class Solution {
    public int minLength(String s) {
        HashMap<Character, Character> pair = new HashMap<>();
        pair.put('B', 'A');
        pair.put('D', 'C');
        
        char[] charArr = s.toCharArray();
        int count = s.length();
        
        for(int i = 0; i < charArr.length; i++){
           if((charArr[i] == 'B' || charArr[i] == 'D') && i > 0) {
                int prevIdx = i - 1;
                
                while(prevIdx >= 0 && charArr[prevIdx] == '.'){
                    prevIdx--;
                }
               
                if(prevIdx >= 0 && charArr[prevIdx] == pair.get(charArr[i])){
                    charArr[i] = '.';
                    charArr[prevIdx] = '.';
                    count -= 2;
                }
           }
        }
        
        return count;
    }
}