# https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
# O(n) runtime, O(1) space
class Solution(object):
    def maxProfit(self, prices):
        # Sweet python one-liner
        return sum(max(prices[i + 1] - prices[i], 0) for i in range(len(prices) - 1))
