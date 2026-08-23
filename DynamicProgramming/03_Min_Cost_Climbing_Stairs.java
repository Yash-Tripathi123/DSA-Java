class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length];
        for(int i=0; i<cost.length; i++){
            dp[i]=-1;
        }
        int ans1 = helper(cost, 0,dp);
        int ans2 = helper(cost, 1,dp);
        return Math.min(ans1, ans2);
    }
    public int helper(int cost[], int i, int dp[]){
        if (i>=cost.length){
            return 0;
        }
        if(dp[i]!=-1) return dp[i];
        
        int step1 = cost[i] + helper(cost, i+1,dp);
        int step2 = cost[i] + helper(cost, i+2,dp);

         dp[i] = Math.min(step1,step2);
         return dp[i];
    }
}