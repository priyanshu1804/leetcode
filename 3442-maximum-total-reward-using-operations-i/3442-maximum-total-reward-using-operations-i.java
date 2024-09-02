class Solution {
    public int solve(int i,int total,int[] rewardValues,int[][] dp){
        int n=rewardValues.length;
        if(i>=n){
            return total;
        }
        if(dp[i][total]!=-1){
            return dp[i][total];
        }
        int notpick=solve(i+1,total,rewardValues,dp);
        int pick=0;
        if(rewardValues[i]>total){
            pick=solve(i+1,total+rewardValues[i],rewardValues,dp);
        }
        return dp[i][total]=Math.max(pick,notpick);
    }
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int[][] dp=new int[rewardValues.length][4001];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(0,0,rewardValues,dp);
    }
}