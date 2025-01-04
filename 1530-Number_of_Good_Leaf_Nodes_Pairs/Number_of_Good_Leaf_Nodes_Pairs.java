class Solution {
    int count = 0;
    public int countPairs(TreeNode root, int distance) {
        calculatePairs(root, distance);
        
        return count;
    }
    
    private int[] calculatePairs(TreeNode root, int distance){
        if(root == null){
            return new int[distance + 1];
        }
        
        // leaf node
        if(root.left == null && root.right == null){
            int[] arr = new int[distance + 1];
            arr[1] = 1; // one leaf node
            return arr;
        }
        
        
        int[] rightNodes = calculatePairs(root.right, distance);
        int[] leftNodes = calculatePairs(root.left, distance);
        
        // Find count by pairing up left and right leaves (Multiple left and right)
        for(int left = 1; left <= distance; left++){
            for(int right = distance - left; right >= 1; right--){
                count += (rightNodes[right] * leftNodes[left]);
            }
        }
        
        int[] newArr = new int[distance + 1];
        for(int i = 1; i < newArr.length - 1; i++){
            newArr[i + 1] = leftNodes[i] + rightNodes[i];
        }
        
        return newArr;
    }
}
