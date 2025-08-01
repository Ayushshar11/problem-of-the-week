package week_3;

// Count Unival Subtrees [Week 3 → Question 2]
// Approach 1: Bottom-Up Recursive DFS (Post-Order Traversal)
// Time: O(N), Space: O(H) where H = height of the tree

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class CountUnivalSubtrees {

    // TreeNode class
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }

    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input in level-order (use -1 for null)
        String[] values = sc.nextLine().split(" ");
        TreeNode root = buildTree(values);

        // Count unival subtrees
        count = 0;
        isUnival(root);
        System.out.println(count);
    }

    // Helper to build tree from level-order input
    private static TreeNode buildTree(String[] values) {
        if (values.length == 0 || values[0].equals("-1")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (i < values.length) {
            TreeNode current = queue.poll();

            // Left child
            if (!values[i].equals("-1")) {
                current.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.left);
            }
            i++;
            if (i >= values.length) break;

            // Right child
            if (!values[i].equals("-1")) {
                current.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    // DFS to check if subtree rooted at node is unival
    private static boolean isUnival(TreeNode node) {
        if (node == null) return true;

        boolean left = isUnival(node.left);
        boolean right = isUnival(node.right);

        if (!left || !right) return false;
        if (node.left != null && node.left.val != node.val) return false;
        if (node.right != null && node.right.val != node.val) return false;

        count++;
        return true;
    }
}
