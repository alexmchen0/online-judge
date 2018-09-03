# https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv
class Solution(object):
    # balance[i][j] = max balance using at most j transactions up to i-th day
    # profit[i][j] = max profit using at most j transactions up to i-th day
    # balance[i][j] = max(profit[j-1] - prices[i], balance[i-1][j])
    # profit[i][j] = max(balance[i][j] + prices[i], profit[i-1][j])
    # O(kn) runtime, O(k) space
    def maxProfit(self, k, prices):
        """
        :type k: int
        :type prices: List[int]
        :rtype: int
        """
        n = len(prices)
        if k >= n // 2:
            # Can use as many transactions as needed
            return sum(x - y for x, y in zip(prices[1:], prices[:-1]) if x > y)

        balance = [float('-inf')] * (k+1)
        profit = [0] * (k+1)

        for i in range(n):
            for j in range(1, k+1):
                balance[j] = max(profit[j-1] - prices[i], balance[j]) # decide whether to buy at prices[i]
                profit[j] = max(balance[j] + prices[i], profit[j]) # decide whether to sell at prices[i]

        return profit[k]
