// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

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
    // Stores root of branch that was previously flattened
    private TreeNode prevRoot = null;

    // Recursively flattens using post-order traversal
    // Visits each node once: O(n) time, O(h) space
    public void flatten(TreeNode root) {
        if (root == null) return;

        // Flattens subtrees in post-order
        // This ensures flattened right sub-list comes after the left sub-list
        flatten(root.right);
        flatten(root.left);

        // After children are flattened, just set head of sub-list as child
        root.right = prevRoot;
        root.left = null;

        prevRoot = root
    }
}
