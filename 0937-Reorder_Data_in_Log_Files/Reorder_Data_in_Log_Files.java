import java.util.*;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> digitList = new ArrayList<>();
        List<String> letterList = new ArrayList<>();
        
        // Split into digits and letters list
        // O(n)
        for(int i = 0; i < logs.length; i++){
            String[] splittedStr = logs[i].split("\s");
            char[] splittedChars = splittedStr[1].toCharArray();
            
            if(splittedChars[0] <= '9' && splittedChars[0] >= '0') digitList.add(logs[i]);
            else letterList.add(logs[i]);
        }
        
        letterList.sort(new Comparator<String>(){
            public int compare(String s1, String s2){
                String comparator1 = s1.substring(s1.indexOf(" "));
                String comparator2 = s2.substring(s2.indexOf(" "));
                
                int result = comparator1.compareTo(comparator2);
                if(result == 0){
                    return s1.substring(0, s1.indexOf(" ")).compareTo(s2.substring(0, s2.indexOf(" ")));
                }
                
                return result;
            }
        });
        
        // Insert into a new array
        String[] ans = new String[logs.length];
        int numOfLettersLog = logs.length - digitList.size();
        int p = 0;
        
        
        for(int i = 0; i < letterList.size(); i++){
            ans[p++] = letterList.get(i);
        }
        
        for(int i = 0 ; i < digitList.size(); i++){
            ans[p++] = digitList.get(i);
        }
        
        return ans;
    }
}