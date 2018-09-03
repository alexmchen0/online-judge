# https://leetcode.com/problems/path-sum/description/

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # Recursively checks each root-to-leaf path
    # Visits each node once: O(n) time, O(h) space
    def hasPathSum(self, root, sum):
        if root is None:
            return False

        # Find remaining sum
        sum -= root.val

        # If the current root is a leaf
        if root.left is None and root.right is None:
            return sum == 0

        # Otherwise, visit children
        return self.hasPathSum(root.left, sum) or self.hasPathSum(root.right, sum)
