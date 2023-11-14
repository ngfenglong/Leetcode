class Solution {
    public int countPalindromicSubsequence(String s) {
        List<Character> list = new ArrayList<>();
        
        int[][] order = new int[26][2];
        for(int i = 0; i < 26; i++){
            Arrays.fill(order[i], -1);
        }
        
        for(int i = 0 ; i < s.length(); i++){
            int idx = s.charAt(i) - 'a';
            list.add(s.charAt(i));
            if(order[idx][0] != -1){
                order[idx][1] = i;
            }
            else{
                order[idx][0] = i;
            }
        }
        
        int count = 0;
        for(int i = 0; i < 26; i++){
            if(order[i][1] != -1 && (order[i][1] - order[i][0] > 1)){
                Set<Character> unique = new HashSet<>(list.subList(order[i][0] + 1, order[i][1]));
                count += unique.size();
            }
        }
        
        return count;
    }
}