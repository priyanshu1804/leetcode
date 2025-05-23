class Solution {
    public long solve(int i,int flag,int[] nums,int k,long[][] dp){
        if(i==nums.length){
            return flag==1?0:Integer.MIN_VALUE;
        }
        if(dp[i][flag]!=-1){
            return dp[i][flag];
        }
        long notpick=nums[i]+solve(i+1,flag,nums,k,dp);
        long pick=(nums[i]^k)+solve(i+1,flag^1,nums,k,dp);
        return dp[i][flag]=Math.max(notpick,pick);
    }
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long[][] dp=new long[nums.length+1][2];
        for(long[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(0,1,nums,k,dp);
    }
}