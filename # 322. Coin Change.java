class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int minCoin = Integer.MIN_VALUE;
        for (int coin : coins) {
            minCoin = Math.min(minCoin, coin);
        }
        for (int i = 1; i < minCoin && i <= amount; i++) {
            dp[i] = -1;
        }
        for (int i = 1; i <= amount; i++) {
            boolean isSum = false;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != -1) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                    isSum = true;
                }
            }
            if (!isSum) dp[i] = -1;
        }
        return dp[amount];
    }
}