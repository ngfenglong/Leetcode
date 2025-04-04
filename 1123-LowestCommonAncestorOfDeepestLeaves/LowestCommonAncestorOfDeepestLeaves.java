import java.util.*;

public class LowestCommonAncestorOfDeepestLeaves {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        // Find the lowest level -> If only 1-> Return,
        // else while loop till ancestor is the same
        HashMap<Integer, List<TreeNode>> treeLevels = new HashMap<>();
        HashMap<Integer, TreeNode> parents = new HashMap<>();

        public TreeNode lcaDeepestLeaves(TreeNode root) {
            return checkDescendant(root);
        }

        private TreeNode checkDescendant(TreeNode root) {
            if (root == null)
                return root;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int level = 0;

            while (!queue.isEmpty()) {
                treeLevels.put(level, new ArrayList<>());
                int count = queue.size();

                while (count > 0) {
                    TreeNode temp = queue.poll();
                    treeLevels.get(level).add(temp);

                    if (temp.left != null) {
                        parents.put(temp.left.val, temp);
                        queue.add(temp.left);
                    }
                    if (temp.right != null) {
                        parents.put(temp.right.val, temp);
                        queue.add(temp.right);
                    }

                    count--;
                }
                level++;
            }

            level--;

            List<TreeNode> leavesNodes = treeLevels.get(level);
            if (leavesNodes.size() == 1)
                return leavesNodes.get(0);

            return findAncestor(leavesNodes);

        }

        private TreeNode findAncestor(List<TreeNode> nodes) {
            Set<TreeNode> parentSet = new HashSet<>();
            List<TreeNode> currChildren = nodes;

            while (currChildren.size() != 1) {
                for (TreeNode temp : currChildren) {
                    parentSet.add(parents.get(temp.val));
                }

                currChildren = new ArrayList<>(parentSet);
                parentSet = new HashSet<>();
            }

            return currChildren.get(0);
        }
    }

}