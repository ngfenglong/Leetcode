class FindUniqueBinaryString {
    class Solution {
        public String findDifferentBinaryString(String[] nums) {
            StringBuilder sb = new StringBuilder();
    
            for(int i = 0; i < nums.length; i++){
                char iPosChar = (nums[i].charAt(i) == '0') ? '1' : '0';
    
                sb.append(iPosChar);
            }
    
            return sb.toString();
        }
    }
}
