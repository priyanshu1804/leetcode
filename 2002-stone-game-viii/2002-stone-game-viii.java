class Solution {
    public int solve(int[] stones,int i,int flag,int[][] dp,int n){
        if(i==n){
            return 0;
        }
        if(i==n-1){
            return flag==1?stones[i]:-stones[i];
        }
        if(dp[i][flag]!=-1){
            return dp[i][flag];
        }
        if(flag==1){
            dp[i][flag]=Math.max(stones[i]+solve(stones,i+1,0,dp,n),solve(stones,i+1,1,dp,n));
        }else{
            dp[i][flag]=Math.min(-stones[i]+solve(stones,i+1,1,dp,n),solve(stones,i+1,0,dp,n));
        }
        return dp[i][flag];
    }
    public int stoneGameVIII(int[] stones) {
        int n=stones.length;
        int[][] dp=new int[n][2];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        for(int i=1;i<n;i++){
            stones[i]+=stones[i-1];
        }
        return solve(stones,1,1,dp,n);
    }
}