
class KthLargestElements {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int smallestK = nums.length - k;
            return quickSelect(nums, 0, nums.length - 1, smallestK);
            
        }
        
        private int quickSelect(int[] arr, int left, int right, int smallestK){
            int position = partition(left, right, arr);
            if(position == smallestK) return arr[position];
            else if(position < smallestK) return quickSelect(arr, position + 1, right, smallestK);
            else return quickSelect(arr, left, position - 1, smallestK);
            
        }
        
        private int partition(int left, int right, int[] arr){
            int pivotIdx = left;
            int pivot = arr[pivotIdx];
            
            swap(arr, pivotIdx, right);
                    
            int endPos = left;
            for(int i = left; i < right; i++){
                if(arr[i] < pivot){
                    swap(arr, i, endPos);
                    endPos++;
                }
            }
            
            swap(arr,endPos, right);
            return endPos;
                    
        }
        
        private void swap(int[] arr, int a, int b){
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }
}
