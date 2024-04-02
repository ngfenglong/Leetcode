class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(t.length() != s.length()) return false;
        int[] check1 = new int[128];
        int[] check2 = new int[128];
        
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray(); 
        
        int i = 0;
        while(i < sArr.length){
            if(check1[sArr[i]] != check2[tArr[i]]) return false;
            check1[sArr[i]] = i + 1;
            check2[tArr[i]] = i + 1;
            i++;
        }
        
        return true;
    }
}