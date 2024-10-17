class Solution {
    public int maximumSwap(int num) {
        char[] arr = ("" + num).toCharArray();
        int[] maxRightIndex = new int[arr.length];
                    
        maxRightIndex[arr.length - 1] = arr.length - 1;
        
        for(int i = arr.length - 2; i >= 0; i--){
            if(arr[i] > arr[maxRightIndex[i + 1]]) maxRightIndex[i] = i;
            else {
                maxRightIndex[i] = maxRightIndex[i+1];
            }
        }
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < arr[maxRightIndex[i]]){
                swap(arr, i, maxRightIndex[i]);
                return buildNewInt(arr);
            }
        }
        
        return num;
    }
    
    private int buildNewInt(char[] arr){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < arr.length; i++){
            sb.append(arr[i]);
        }
        
        return Integer.parseInt(sb.toString());
    }
    
    private void swap(char[] arr, int i1, int i2){
        char temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}