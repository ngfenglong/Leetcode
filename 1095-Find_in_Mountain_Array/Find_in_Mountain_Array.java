/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    HashMap<Integer, Integer> cache = new HashMap<>();
    MountainArray mountainArr;
    
    public int findInMountainArray(int target, MountainArray mountainArr) {
        this.mountainArr = mountainArr;
        int n = mountainArr.length();
        
        int left = 1;
        int right = n - 2;
        
        // To find the peak
        while(left != right){
            int mid = (left + right)/2;
            if(getValue(mid) < getValue(mid+ 1)){
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        
        int peak = right;
        
        // Checking the left side of the mountain array
        left = 0;
        right = peak;
        while(left <= right){
            int mid = left + (right - left)/2;
            int midValue = getValue(mid);
            if(midValue == target){
                return mid;
            }
            else if(midValue < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        
        // Checking the right side of the mountain array
        left = peak + 1;
        right = n - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            int midValue = getValue(mid);
            if(midValue == target){
                return mid;
            }
            else if(midValue > target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
    private int getValue(int idx){
        if(cache.containsKey(idx)){
            return cache.get(idx);
        }
        
        int value = mountainArr.get(idx);
        cache.put(idx, value);
        return value;
    }
}