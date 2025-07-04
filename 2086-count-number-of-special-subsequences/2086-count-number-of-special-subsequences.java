class Solution {
    final int MOD=(int)1e9+7;
    public long solve(int[] nums,int i,int prev,long[][] dp){
        if(i>=nums.length){
            return prev==2?1:0;
        }
        if(dp[i][prev+1]!=-1){
            return dp[i][prev+1];
        }
        long way0=0,way1=0,way2=0,way3=0,way4=0,way5=0,way6=0;
        if(prev==-1&&nums[i]==0){
            way0=solve(nums,i+1,0,dp);
        }
        if(prev==0&&nums[i]==0){
            way1=solve(nums,i+1,0,dp);
        }
        if(prev==0&&nums[i]==1){
            way2=solve(nums,i+1,1,dp);
        }
        if(prev==1&&nums[i]==1){
            way3=solve(nums,i+1,1,dp);
        }
        if(prev==1&&nums[i]==2){
            way4=solve(nums,i+1,2,dp);
        }
        if(prev==2&&nums[i]==2){
            way5=solve(nums,i+1,2,dp);
        }
        way6=solve(nums,i+1,prev,dp);
        return dp[i][prev+1]=(way0+way1+way2+way3+way4+way5+way6)%MOD;
    }
    public int countSpecialSubsequences(int[] nums) {
        int n=nums.length;
        long[][] dp=new long[n][4];
        for(long[] it:dp){
            Arrays.fill(it,-1);
        }
        return (int)solve(nums,0,-1,dp);
    }
}