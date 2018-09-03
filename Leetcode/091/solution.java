// https://leetcode.com/problems/decode-ways/description/
class Solution {
    int numDecodings(String s) {
        // dp[i] = number of ways to decode s.subString(0, i + 1);
        // either dp[i] = dp[i-1] or dp[i] = dp[i-1] + dp[i-2] (Understand this)
        // O(n) runtime, O(1) space
        if (s.length() == 0 || s.charAt(0) == '0') return 0;

        // a = dp[i-2] , b = dp[i-1]
        int dp_2 = 1, dp_1 = 1;

        for (int i = 1; i < s.length(); i++) {
            char digit = s.charAt(i);
            char prevDigit = s.charAt(i - 1);
            int dp = 0;

            if (digit > '0') {
                dp += dp_1; // valid one-digit, build on dp[i-1]
            } else if (prevDigit != '1' && prevDigit != '2') {
                return 0; // found a 0 that's not part of a two-digit, invalid
            }

            if (prevDigit == '1' || prevDigit == '2' && digit <= '6') {
                dp += dp_2; // valid two-digit, build on dp[i-2]
            }

            dp_2 = dp_1;
            dp_1 = dp;
        }
        return dp_1;
    }
}
