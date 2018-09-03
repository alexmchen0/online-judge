// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv
class Solution{
    // balance[i][j] = max balance using at most j transactions up to i-th day while holding the stock
    // profit[i][j] = max profit using at most j transactions up to i-th day while not holding the stock
    // balance[i][j] = max(profit[i][j-1] - prices[i], balance[i-1][j])
    // profit[i][j] = max(balance[i][j] + prices[i], profit[i-1][j])
    // O(kn) runtime, O(k) space
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k >= n / 2) {
            // Can use as many transactions as needed
            return quickSolve(prices);
        }

        int[] balance = new int[k+1];
        Arrays.fill(balance, Math.MIN_VALUE);
        int[] profit = new int[k+1];

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                balance[j] = Math.max(profit[j-1] - prices[i], balance[j]); // decide whether to buy at prices[i]
                profit[j] = Math.max(balance[j] + prices[i], profit[j]); // decide whether to sell at prices[i]
            }
        }

        return profit[k];
    }

    private int quickSolve(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
