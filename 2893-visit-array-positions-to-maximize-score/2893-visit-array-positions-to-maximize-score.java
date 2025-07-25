class Solution {
    public long solve(int i,int prev,int x,int[] nums,long[][] dp){
        if(i==nums.length){
            return 0;
        }
        if(dp[i][prev]!=-1){
            return dp[i][prev];
        }
        long notpick=solve(i+1,prev,x,nums,dp);
        long pick=nums[i]+solve(i+1,(nums[i]&1),x,nums,dp);
        if((nums[i]&1)!=prev){
            pick-=x;
        }
        return dp[i][prev]=Math.max(pick,notpick);
    }
    public long maxScore(int[] nums, int x) {
        int n=nums.length;
        long[][] dp=new long[n][2];
        for(long[] it:dp){
            Arrays.fill(it,-1);
        }
        return nums[0]+solve(1,(nums[0]&1),x,nums,dp);
    }
}