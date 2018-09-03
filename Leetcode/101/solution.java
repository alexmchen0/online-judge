// https://leetcode.com/problems/symmetric-tree/description/

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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    // Recursively determines if two branches are mirrors of each other
    public boolean isMirror(TreeNode t1, TreeNode t2) {
        // Base case 1: Both branches are null
        if (t1 == null && t2 == null) return true;

        // Base case 2: One branch is null and the other is not
        if (t1 == null || t2 == null) return false;

        // Base case 3: The values of two roots are different
        if (t1.val != t2.val) return false;

        return isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }
}
