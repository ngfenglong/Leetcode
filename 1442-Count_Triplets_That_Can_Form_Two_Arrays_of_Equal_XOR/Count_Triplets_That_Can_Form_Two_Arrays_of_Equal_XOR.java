class Solution {
    public int countTriplets(int[] arr) {
        // i < j <= k
        int[] prefixArr = new int[arr.length + 1];

        prefixArr[0] = 0;
        System.arraycopy(arr, 0, prefixArr, 1, arr.length);
        int size = prefixArr.length;
        
        for(int i = 1; i < prefixArr.length; i++){
            prefixArr[i] ^= prefixArr[i - 1];
        }

        int count = 0;
        for(int i = 0; i < prefixArr.length; i++){
            for(int j = i + 1; j < prefixArr.length; j++){
                if(prefixArr[i] == prefixArr[j]){
                    count += (j - i - 1);    
                }
            }
        }
        
        
        return count;
    }
    
    
}