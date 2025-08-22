class Solution {
    public long solve(int i,int left,int up,long[][][] dp,int[][] cost,int n){
        if(i>=n/2){
            return 0;
        }
        if(dp[i][left][up]!=-1){
            return dp[i][left][up];
        }
        long ans=Long.MAX_VALUE;
        for(int col1=0;col1<3;col1++){
            if(col1!=left){
                for(int col2=0;col2<3;col2++){
                    if(col2!=up&&col1!=col2){
                        long ans1=cost[i][col1]+cost[n-i-1][col2]+solve(i+1,col1,col2,dp,cost,n);
                        ans=Math.min(ans,ans1);
                    }
                }
            }
        }
        return dp[i][left][up]=ans;
    }
    public long minCost(int n, int[][] cost) {
        long[][][] dp=new long[n][4][4];
        for(long[][] rows:dp){
            for(long[] it:rows){
                Arrays.fill(it,-1);
            }
        }
        return solve(0,3,3,dp,cost,n);
    }
}