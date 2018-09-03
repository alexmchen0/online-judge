// https://leetcode.com/problems/validate-binary-search-tree/description/

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
    // Visits each node once: O(n) time, O(h) space
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Recursively determine if a tree is a valid BST
    private boolean isValid(TreeNode root, long min, long max) {
        // Base cases
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;

        return isValid(root.left, min, root.val) &&
               isValid(root.right, root.val, max);
    }
}
