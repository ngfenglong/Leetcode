class Solution {
    public int findComplement(int num) {
        StringBuilder sb = new StringBuilder();
        
        while(num > 0){
            if(num % 2 == 1) sb.append("0");
            else sb.append("1");
            num /= 2;
        }
        
        return Integer.parseInt(sb.reverse().toString(), 2);        
    }
}