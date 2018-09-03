# https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def flatten(self, root):
        # Stores root of branch that was previously flattened
        self.prev_root = None

        # Recursively flattens using post-order traversal
        # Visits each node once: O(n) time, O(h) space
        def flatten(root):
            if not root:
                return

            # Flattens subtrees in post-order
            # This ensures flattened right sub-list comes after the left sub-list
            flatten(root.right)
            flatten(root.left)

            # After children are flattened, just set head of sub-list as child
            root.right = self.prev_root
            root.left = None

            self.prev_root = root

        flatten(root)
