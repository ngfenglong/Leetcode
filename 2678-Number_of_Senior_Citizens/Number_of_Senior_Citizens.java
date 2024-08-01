class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        
        for(int i = 0; i < details.length; i++){
            // Access index straight should be faster than substring
            StringBuilder sb = new StringBuilder();
            sb.append(details[i].charAt(11));
            sb.append(details[i].charAt(12));
            int age = Integer.parseInt(sb.toString());
            if(age > 60) count++;
        }
        
        return count;
    }
}