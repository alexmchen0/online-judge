# https://leetcode.com/problems/balanced-binary-tree/description/

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    # Recursively determine if a binary tree is balanced
    # Visits each node once: O(n) time, O(h) space
    def isBalanced(self, root):
        # Find the height of a tree given its root
        # return -1 if unbalanced
        def height(root):
            # Base case
            if root is None:
                return 0

            left_height  = height(root.left)
            right_height = height(root.right)

            # If tree is unbalanced, return -1
            if left_height == -1 or right_height == -1 or \
                abs(left_height - right_height) > 1:
                return -1

            # Otherwise, return height of tree
            return 1 + max(left_height, right_height)

        return height(root) != -1
