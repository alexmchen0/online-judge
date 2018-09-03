# https://leetcode.com/problems/coin-change/description/
class Solution(object):
    # dp[i] = min(dp[i - coin] + 1) over all coins
    # O(n) runtime, O(n) space
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        dp = [amount + 1] * (amount + 1)
        dp[0] = 0
        for i in range(amount + 1):
            for coin in coins:
                if coin <= i:
                    dp[i] = min(dp[i], dp[i - coin] + 1)
        return -1 if dp[amount] > amount else dp[amount]
