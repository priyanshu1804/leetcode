class Solution {
    public int solve(int idx,int count,int[] satisfaction,int[][] dp,int n){
        if(idx==n){
            return 0;
        }
        if(dp[idx][count]!=-1){
            return dp[idx][count];
        }
        int pick=satisfaction[idx]*(count+1)+solve(idx+1,count+1,satisfaction,dp,n);
        int notpick=solve(idx+1,count,satisfaction,dp,n);
        return dp[idx][count]=Math.max(pick,notpick);
    }
    public int maxSatisfaction(int[] satisfaction) {
        int n=satisfaction.length;
        Arrays.sort(satisfaction);
        int[][] dp=new int[n][n+1];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(0,0,satisfaction,dp,n);
    }
}