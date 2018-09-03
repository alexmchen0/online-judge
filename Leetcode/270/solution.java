// https://leetcode.com/problems/closest-binary-search-tree-value/description

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
    // Iteratively walks down path of tree closest to the target
    // Walks down one branch; O(h) time, O(1) space
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        while (root != null) {
            // Update closest if necessary
            if (Math.abs(closest - target) >= Math.abs(root.val - target)) {
                closest = root.val;
            }
            // Choose which child to visit next
            root = target < root.val ? root.left : root.right;
        }
        return closest;
    }
}
