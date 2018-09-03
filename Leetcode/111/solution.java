// https://leetcode.com/problems/minimum-depth-of-binary-tree/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // Recursively checks each root-to-leaf path
    // Note that a BFS approach could be faster but has same worst case runtime
    // Visits each node once: O(n) time, O(h) space
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        // If either child is null, can't use its depth
        if (left == 0 || right == 0) return 1 + left + right

        // Otherwise, use the smaller of the two child depths
        return 1 + Math.min(left, right);
    }
}
