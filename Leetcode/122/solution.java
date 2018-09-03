// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
// O(n) runtime, O(1) space
class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
