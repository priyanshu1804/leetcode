class Solution {
    public long solve(int n,long[] dp){
        if(n<=0){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        long ans=0;
        ans+=1L*solve(n-2,dp);
        ans+=1L*solve(n-1,dp);
        return dp[n]=ans%1000000007;
    }
    public int countHousePlacements(int n) {
        long[] dp=new long[n+1];
        Arrays.fill(dp,-1);
        solve(n,dp);
        long ans=dp[n];
        return (int)((ans*ans)%1000000007);
    }
}