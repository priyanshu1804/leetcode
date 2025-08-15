class Solution {
    public long solve(int[] nums,long[][] dp,int idx,int state){
        if(idx==nums.length){
            return 0;
        }
        long ans=Long.MIN_VALUE;
        if(dp[idx][state]!=-1){
            return dp[idx][state];
        }
        long notpick=solve(nums,dp,idx+1,state);
        long pick=(state==0?1:-1)*nums[idx]+solve(nums,dp,idx+1,state^1);
        return dp[idx][state]=Math.max(pick,notpick);
    }
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        long[][] dp=new long[n+1][2];
        for(long[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(nums,dp,0,0);
    }
}