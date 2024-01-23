class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        
        if(total % 2 == 1) {
            return (double)findKPosition(nums1, nums2, total/2, 0, nums1.length - 1, 0, nums2.length - 1);
        }
        else {
            return ((double)findKPosition(nums1, nums2, total/2 - 1, 0, nums1.length - 1, 0, nums2.length - 1) + (double)findKPosition(nums1, nums2, total/2, 0, nums1.length - 1, 0, nums2.length - 1))/2;
        }
    }
    
    private int findKPosition(int[] nums1, int[] nums2, int k, int aLeft, int aRight, int bLeft, int bRight) {
        if(aRight < aLeft) {
            return nums2[k - aLeft];
        }
        
        if(bRight < bLeft) {
            return nums1[k - bLeft];
        }
        
        int aMid = (aLeft + aRight)/2;
        int bMid = (bLeft + bRight)/2;
        int aValue = nums1[aMid];
        int bValue = nums2[bMid];
        
        // my total index < k --> Need to move to the right (move the smaller one)
        if(aMid + bMid < k) {
            if(aValue > bValue) {
                return findKPosition(nums1, nums2, k, aLeft, aRight, bMid + 1, bRight);
            } else {
                return findKPosition(nums1, nums2, k, aMid + 1, aRight, bLeft, bRight);
            }
        }
        // my total index > k --> Need to move to the left (move the larger one)
        else {
            if(aValue > bValue) {
                return findKPosition(nums1, nums2, k, aLeft, aMid - 1, bLeft, bRight);
            }
            else {
                return findKPosition(nums1, nums2, k, aLeft, aRight, bLeft, bMid - 1);
            }
        }
    }
}