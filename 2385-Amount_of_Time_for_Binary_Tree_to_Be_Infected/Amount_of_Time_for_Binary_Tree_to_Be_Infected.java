import java.util.*;

class Solution {
    HashMap<Integer, List<Integer>> connections = new HashMap<>();

    public int amountOfTime(TreeNode root, int start) {
        // For each Node -> Create a list to show the connection between each
        // Starting with the start node, Do a BFS to see how many level does it take to
        // traverse to all nodes
        // Use a set to trace visited node, and a queue to store the next to visit

        traverseNode(root, null);

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(start);
        int time = 0;
        while (!queue.isEmpty()) {
            int counts = queue.size();

            for (int i = 0; i < counts; i++) {
                int curr = queue.poll();
                if (!visited.contains(curr)) {
                    visited.add(curr);
                    List<Integer> list = connections.get(curr);
                    for (Integer node : list) {
                        if (!visited.contains(node))
                            queue.offer(node);
                    }
                }
            }
            time++;
        }

        return time - 1;
    }

    private void traverseNode(TreeNode root, Integer parent) {
        if (root == null)
            return;

        List<Integer> list = new ArrayList<>();
        if (parent != null)
            list.add(parent);
        if (root.left != null)
            list.add(root.left.val);
        if (root.right != null)
            list.add(root.right.val);
        connections.put(root.val, list);

        traverseNode(root.left, root.val);
        traverseNode(root.right, root.val);
    }

    public class TreeNode {
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