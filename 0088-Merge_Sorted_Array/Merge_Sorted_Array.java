class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] newArr = new int[m+n];
        
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        
        while(p1 < m || p2 < n){
            if(p1 >= m){
                newArr[p++] = nums2[p2++];  
            }
            else if(p2 >= n){
                newArr[p++] = nums1[p1++];  
            }
            else{
                if(nums1[p1] < nums2[p2]){
                    newArr[p++] = nums1[p1++];  
                }
                else{
                    newArr[p++] = nums2[p2++];  
                }
            }
        }
        
        for(int i = 0; i < newArr.length; i++){
            nums1[i] = newArr[i];
        }
    }
}