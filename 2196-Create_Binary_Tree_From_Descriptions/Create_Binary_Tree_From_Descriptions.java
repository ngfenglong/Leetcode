import java.util.*;

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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashSet<Integer> children = new HashSet<>();
        HashSet<Integer> parents = new HashSet<>();
        HashMap<Integer, TreeNode> nodes = new HashMap<>();

        for (int i = 0; i < descriptions.length; i++) {
            int child = descriptions[i][1];
            int parent = descriptions[i][0];

            children.add(child);
            parents.add(parent);
            if (!nodes.containsKey(parent))
                nodes.put(parent, new TreeNode(parent));
            if (!nodes.containsKey(child))
                nodes.put(child, new TreeNode(child));

            if (descriptions[i][2] == 1)
                nodes.get(parent).left = nodes.get(child);
            else
                nodes.get(parent).right = nodes.get(child);
        }

        int root = -1;
        for (Integer parent : parents) {
            if (!children.contains(parent))
                return nodes.get(parent);
        }

        return null;
    }
}