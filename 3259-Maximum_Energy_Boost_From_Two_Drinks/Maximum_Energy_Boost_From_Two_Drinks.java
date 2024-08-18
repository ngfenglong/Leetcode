class Solution {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        
        long[] dpA = new long[n];
        long[] dpB = new long[n];
        
        dpA[n-1] = energyDrinkA[n-1];
        dpB[n-1] = energyDrinkB[n-1];
        dpA[n -2] =  energyDrinkA[n-2] + energyDrinkA[n-1];
        dpB[n -2] += energyDrinkB[n-2] + energyDrinkB[n-1];
        
        for(int i = n - 3; i >= 0 ; i--){
            dpA[i] = Math.max((long)energyDrinkA[i] + dpA[i+1], (long)energyDrinkA[i] + dpB[i + 2]);
            dpB[i] = Math.max((long)energyDrinkB[i] + dpB[i+1], (long)energyDrinkB[i] + dpA[i + 2]);
        }
        
        return Math.max(dpA[0], dpB[0]);
    }
}