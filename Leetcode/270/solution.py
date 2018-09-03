# https://leetcode.com/problems/closest-binary-search-tree-value/description

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    # Iteratively walks down path of tree closest to the target
    # Walks down one branch; O(h) time, O(1) space
    def closestValue(self, root, target):
        closest = root.val
        while root is not None:
            # Update closest if necessary
            if abs(closest - target) >= abs(root.val - target):
                closest = root.val;
            # Choose which child to visit next
            root = root.left if target < root.val else root.right
        return closest
