public class CheckIfOneStringSwapCanMakeStringsEqual {
    class Solution {
        public boolean areAlmostEqual(String s1, String s2) {
            int toSwap = -1;
    
            if(s1.length() != s2.length()) return false;
    
            for(int i = 0; i < s1.length(); i++){
                if(s1.charAt(i) != s2.charAt(i)){
                    if(toSwap == -1){
                        toSwap = i;
                    }
                    else if(toSwap == s1.length()) return false;
                    else {
                        if(s1.charAt(i) == s2.charAt(toSwap) && s1.charAt(toSwap) == s2.charAt(i)) toSwap = s1.length();
                        else return false;
                    }   
                }
            }
    
            return toSwap == -1 || toSwap == s1.length();
        }
    }
}