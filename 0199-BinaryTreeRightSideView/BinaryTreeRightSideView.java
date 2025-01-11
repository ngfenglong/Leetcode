import java.util.*;

class BinaryTreeRightSideView {
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
        HashMap<Integer, List<Integer>> levelHM = new HashMap<>();
        public List<Integer> rightSideView(TreeNode root) {
            fillHM(root, 0);
            
            List<Integer> ans = new ArrayList<>();
            for(Integer lv: levelHM.keySet()){
                List<Integer> level = levelHM.get(lv);
                ans.add(level.get(level.size() - 1));
            }
            
            return ans;
        }
        
        private void fillHM(TreeNode root, int level){
            if(root == null) return;
            
            if(!levelHM.containsKey(level)) levelHM.put(level, new ArrayList<>());
            
            fillHM(root.left, level + 1);
            levelHM.get(level).add(root.val);
            fillHM(root.right, level + 1);
        }
    } 
}
