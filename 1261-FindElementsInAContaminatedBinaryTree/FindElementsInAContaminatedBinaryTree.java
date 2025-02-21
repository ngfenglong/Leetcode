import java.util.*;

public class FindElementsInAContaminatedBinaryTree {

    class FindElements {
        Set<Integer> elements = new HashSet<>();

        public FindElements(TreeNode root) {
            if (root != null) {
                getElements(root, 0);
            }
        }

        public boolean find(int target) {
            return elements.contains(target);
        }

        private void getElements(TreeNode root, int currNum) {
            if (root == null)
                return;

            elements.add(currNum);
            getElements(root.left, currNum * 2 + 1);
            getElements(root.right, currNum * 2 + 2);
        }

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

    }
}