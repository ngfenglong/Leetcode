class Solution {
    public long dividePlayers(int[] skill) {
        int[] skillArr = new int[1001];
        int n = skill.length;
        int total = 0;
        
        for(int i: skill){
            skillArr[i]++;
            total += i;
        }
        
        int skillPerTeam = total/ (n/2);
        long chemistry = 0l;
        
        for(int i: skill){
            if(skillArr[i] == 0) continue;
            
            int needed = skillPerTeam - i;
            if(needed <= 0 || needed > 1000 || skillArr[needed] == 0) return -1l;            

            chemistry += (long)i * needed;
            
            skillArr[i]--;
            skillArr[needed]--;
        }
        
        return chemistry;
    }
}