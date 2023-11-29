class Solution {
    public void nextPermutation(int[] nums) {
        // check if it is the biggest
        boolean biggest = true;
        for(int i = nums.length - 1; i > 0; i--){
            if(nums[i]  > nums[i - 1]){
                swapNextBiggerDigit(nums, i - 1);
                return;
            }
        }
        
        reverseArray(nums, 0, nums.length - 1);
        
    }
    
    private void swapNextBiggerDigit(int[] arr, int toSwap){
        for(int i = arr.length - 1; i > toSwap; i--){
            if(arr[i] > arr[toSwap]){
                int temp = arr[i];
                arr[i] = arr[toSwap];
                arr[toSwap] = temp;
                
                reverseArray(arr, toSwap + 1, arr.length - 1);
                return;
            }
        }
    }

    private void reverseArray(int[] arr, int start, int end) {
        int left = start;
        int right = end;
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    
}