# https://leetcode.com/problems/invert-binary-tree/description/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # Recursively invert
    # Visits each node once: O(n) time, O(h) space
    def invertTree(self, root):
        # Base case:
        if root is None:
            return None

        invert = self.invertTree
        root.left, root.right = invert(root.right), invert(root.left)
        return root
