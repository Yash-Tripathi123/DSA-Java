class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        return helper(n, 0, dp);
    }

    public int helper(int n, int i, int dp[]) {
        if (i > n) return 0;
        if (i == n) return 1;

        if (dp[i] != -1) return dp[i];

        int s1 = helper(n, i + 1, dp);
        int s2 = helper(n, i + 2, dp);

        dp[i] = s1 + s2;
        return dp[i];
    }
}