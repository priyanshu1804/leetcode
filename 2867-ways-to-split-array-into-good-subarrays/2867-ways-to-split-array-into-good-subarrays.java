class Solution {
    int mod=(int)1e9+7;
    public int solve(int i,int count,int[] nums,int[][] dp){
        if(i<0){
            if(count==1){
                return 1;
            }
            return 0;
        }
        if(nums[i]==1){
            count++;
        }
        if(count>1){
            return 0;
        }
        if(dp[i][count]!=-1){
            return dp[i][count];
        }
        int pick=solve(i-1,count,nums,dp)%mod;
        int notpick=0;
        if(count==1){
            notpick=solve(i-1,0,nums,dp)%mod;
        }
        return dp[i][count]=(pick+notpick)%mod;
    }
    public int numberOfGoodSubarraySplits(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][2];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(n-1,0,nums,dp);
    }
}
