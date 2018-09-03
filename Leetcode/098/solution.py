# https://leetcode.com/problems/validate-binary-search-tree/description/

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    # Visits each node once: O(n) time, O(h) space
    def isValidBST(self, root):
        # Recursively determine if a tree is a valid BST
        def isValid(root, min_val, max_val):
            # Base cases
            if root is None:
                return True
            if root.val <= min_val or root.val >= max_val:
                return False

            return isValid(root.left, min_val, root.val) and isValid(root.right, root.val, max_val);

        return isValid(root, -float("inf"), float("inf"))
