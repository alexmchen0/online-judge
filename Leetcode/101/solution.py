# https://leetcode.com/problems/symmetric-tree/description/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # Visits each node once: O(n) time, O(h) space
    def isSymmetric(self, root):
        # Recursively determines if two branches are mirrors of each other
        def isMirror(t1, t2):
            # Base case 1: Both branches are null
            if t1 is None and t2 is None:
                return True

            # Base case 2: One branch is null and the other is not
            if t1 is None or t2 is None:
                return False

            # Base case 3: The values of two roots are different
            if t1.val != t2.val:
                return False

            return isMirror(t1.left, t2.right) and isMirror(t1.right, t2.left)

        if root is None:
            return True
        return isMirror(root.left, root.right)
