// https://leetcode.com/problems/balanced-binary-tree/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // Recursively determine if a binary tree is balanced
    // Visits each node once: O(n) time, O(h) space
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    // Find the height of a tree given its root
    // return -1 if unbalanced.
    private int height(TreeNode root) {
        // Base case
        if (root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // If tree is unbalanced, return -1
        if (leftHeight == -1 || rightHeight == -1 ||
            Math.abs(leftHeight - rightHeight) > 1) return -1;

        // Otherwise, return height of tree
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
