import java.util.*;

class TreeNode {
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
    HashMap<Integer, List<Integer>> hm = new HashMap<>();
    
    public boolean isEvenOddTree(TreeNode root) {
        return recursion(root, 0) && checkCondition();
    }
    
    private boolean recursion(TreeNode root, int level){
        if(root == null) return true; 
        
        if((root.val % 2) == ((level + 2) % 2)) return false;
        
        boolean checkLeft = recursion(root.left, level + 1);
        if(!hm.containsKey(level)) hm.put(level, new ArrayList<>());
        hm.get(level).add(root.val);
        boolean checkRight = recursion(root.right, level + 1);
        
        return checkLeft && checkRight;
    }
    
    private boolean checkCondition(){
        for(Integer lvl: hm.keySet()){
            List<Integer> list = hm.get(lvl);
            for(int i = 1; i < list.size(); i++){
                if((lvl + 2) % 2 == 1 && list.get(i) >= list.get(i - 1)) return false;
                    
                if((lvl + 2) % 2 == 0 && list.get(i) <= list.get(i - 1)) return false;
            }
        }
        return true;
    }
}