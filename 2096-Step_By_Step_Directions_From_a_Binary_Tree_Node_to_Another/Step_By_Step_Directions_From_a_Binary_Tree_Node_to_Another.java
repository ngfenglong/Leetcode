public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode commonAncestor = LCA(root, startValue, destValue);
        
        StringBuilder startPath = new StringBuilder();
        getPath(commonAncestor, startValue, startPath);
        
        StringBuilder endPath = new StringBuilder();
        getPath(commonAncestor, destValue, endPath);
        
        System.out.print(commonAncestor.val);
        for(int i = 0 ; i < startPath.length(); i++){
            startPath.setCharAt(i, 'U');
        }
        
        startPath.append(endPath.toString());
        return startPath.toString();
    }
    
    private TreeNode LCA(TreeNode root, int p, int q){
        if(root == null || root.val == p || root.val == q){
            return root;
        }
        
        TreeNode left = LCA(root.left, p ,q);
        TreeNode right = LCA(root.right, p ,q);
        
        if(left != null && right != null){
            return root;
        }
        
        return left != null ? left : right;
    }
    
    private boolean getPath(TreeNode root, int val, StringBuilder sb){
        if(root == null) return false;
        if(root.val == val) return true;
        
        sb.append("L");
        if(getPath(root.left, val, sb)){
            return true;
        }
        sb.deleteCharAt(sb.length() - 1);
        
        sb.append("R");
        if(getPath(root.right, val, sb)){
            return true;
        }
        sb.deleteCharAt(sb.length() - 1);
        
        return false;
    }
}