class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] numOfTrust = new int[n + 1];
        int[] numOfTrusted = new int[n + 1];
        
        for(int i = 0; i < trust.length; i++){
            numOfTrusted[trust[i][1]]++;
            numOfTrust[trust[i][0]]++;
        }
        

        for(int i = 1; i <= n; i++){
            if(numOfTrusted[i] == (n - 1) && numOfTrust[i] == 0){
                return i;
            }
        }
        
        return -1;
    }
}