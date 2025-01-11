
class SortAnArray {
    class Solution {
        public int[] sortArray(int[] nums) {
            return mergeSort(nums, 0, nums.length - 1);
        }
        
        private int[] mergeSort(int[] nums, int left, int right){
            if(left >= right) return new int[]{nums[right]};
            
            int mid = left + (right - left)/2;
            int[] first = mergeSort(nums, left, mid);
            int[] second = mergeSort(nums, mid + 1, right);
            
            int[] arr = new int[right - left + 1];
            int p1 = 0;
            int p2 = 0;
            int p = 0;
            while(p1 < first.length && p2 < second.length){
                if(first[p1] < second[p2]){
                    arr[p++] = first[p1++];
                }
                else{
                    arr[p++] = second[p2++];
                }
            }
            
            while(p1 < first.length){
                arr[p++] = first[p1++];
            }
            
            while(p2 < second.length){
                arr[p++] = second[p2++];
            }
            
            return arr;
        }
    }
}
