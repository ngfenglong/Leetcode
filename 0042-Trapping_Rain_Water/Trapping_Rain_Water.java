class Solution {
    public int trap(int[] height) {
        int[] leftToRight = new int[height.length];
        int[] rightToLeft = new int[height.length];
        
        int curr = 0;
        for(int i = 0; i < height.length; i++){
            curr = Math.max(height[i], curr);
            leftToRight[i] = curr;
        }
        
        curr = 0;
        for(int i = height.length - 1; i >= 0; i--){
            curr = Math.max(height[i], curr);
            rightToLeft[i] = curr;
        }
        
        int count = 0;
        for(int i = 1; i < height.length - 1; i++){
            count += (Math.min(leftToRight[i],rightToLeft[i]) - height[i]);
        }
        return count;
    }
}