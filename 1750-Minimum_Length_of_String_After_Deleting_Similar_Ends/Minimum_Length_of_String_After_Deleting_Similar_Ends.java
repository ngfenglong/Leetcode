class Solution {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        char[] arr = s.toCharArray();
        while(left < right){
            if(arr[left] != arr[right]) {
                return (right - left + 1);
            }
            while(left + 1 < right && arr[left] == arr[left + 1]){
                left++;
            }
            while(left < right - 1 && arr[right] == arr[right-1]){
                right--;
            }
            
            left++;
            right--;
        }
        
        return (right - left + 1);
    }
}