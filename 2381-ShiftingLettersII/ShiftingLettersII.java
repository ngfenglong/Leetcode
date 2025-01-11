
class ShiftingLettersII {
    class Solution {
        public String shiftingLetters(String s, int[][] shifts) {
            int[] shiftsController = new int[s.length() + 1];
    
            for(int[] shift: shifts){    
                if(shift[2] == 0){
                    // move back
                    shiftsController[shift[0]]--;
                    shiftsController[shift[1] + 1]++;
                }
                else{
                    // move forward
                    shiftsController[shift[0]]++;
                    shiftsController[shift[1] + 1]--;
                }
            }
    
            // Ans
            StringBuilder sb = new StringBuilder();
            int shift = 0;
            for(int i = 0; i < s.length(); i++){
                shift = (shift + shiftsController[i]) % 26; // Could be negative
    
                if(shift < 0) shift += 26;
    
                char c = (char)('a' + ((s.charAt(i) - 'a') + shift) % 26);
                sb.append(c);
            }
    
            return sb.toString();
        }
    }
}
