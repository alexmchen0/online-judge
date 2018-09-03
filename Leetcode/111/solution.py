# https://leetcode.com/problems/minimum-depth-of-binary-tree/description/

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    # Recursively checks each root-to-leaf path
    # Note that a BFS approach could be faster but has same worst case runtime
    # Visits each node once: O(n) time, O(h) space
    def minDepth(self, root):
        if root is None:
            return 0

        left = self.minDepth(root.left)
        right = self.minDepth(root.right)

        # If either child is null, can't use its depth
        if left == 0 or right == 0:
            return 1 + left + right

        # Otherwise, use the smaller of the two child depths
        return 1 + min(left, right)
