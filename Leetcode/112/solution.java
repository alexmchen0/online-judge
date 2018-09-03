// https://leetcode.com/problems/path-sum/description/

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
    // Recursively checks each root-to-leaf path
    // Visits each node once: O(n) time, O(h) space
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        // Find remaining sum
        sum -= root.val;

        // If the current root is a leaf
        if (root.left == null && root.right == null) return sum == 0;

        // Visit children otherwise
        return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);
    }
}
