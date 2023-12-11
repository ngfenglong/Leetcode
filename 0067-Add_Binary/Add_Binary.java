class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        
        while(p1 >= 0 && p2 >= 0){
            int total = carry + (a.charAt(p1--) - '0') + (b.charAt(p2--) - '0');
            carry = total / 2;
            sb.append(total % 2);
        }
        
        while(p1 >= 0){
            int total = carry +  (a.charAt(p1--) - '0');
            carry = total / 2;
            sb.append(total % 2);
            
        }
        while (p2 >= 0){
            int total = carry + (b.charAt(p2--) - '0');
            carry = total / 2;
            sb.append(total % 2);
        }
        if(carry > 0){
            sb.append(carry);
        }
        
        return sb.reverse().toString();
        
    }
}