class Solution {
    public int solve(int low,int high,int one,int zero,int idx,int[] dp){
        if(idx>high){
            return 0;
        }
        int count=0;
        if(dp[idx]!=-1){
            return dp[idx];
        }
        if(idx>=low&&idx<=high){
            count=1;
        }
        int zero1=solve(low,high,one,zero,idx+zero,dp);
        int one1=solve(low,high,one,zero,idx+one,dp);
        return dp[idx]=(count+(one1+zero1)%1000000007)%1000000007;
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp=new int[high+1];
        Arrays.fill(dp,-1);
        return solve(low,high,one,zero,0,dp);
    }
}