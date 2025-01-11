import java.util.*;

class LargestNumber {
    class Solution {
        public String largestNumber(int[] nums) {
            StringBuilder sb = new StringBuilder();
            String[] strs = new String[nums.length];
            
            
            for(int i = 0 ; i < nums.length; i++){
                strs[i] = "" + nums[i];
            }
            
            Arrays.sort(strs, new Comparator<String>(){
                @Override
                public int compare(String s1, String s2){
                    String order1 = s1 + s2;
                    String order2 = s2 + s1;
                    return order2.compareTo(order1);
                }
            });
            
            if(strs[0].equals("0")) return "0";        
            for(int i = 0; i < strs.length; i++){
                sb.append(strs[i]);
            }
            
            return sb.toString();
        }
    }
}
