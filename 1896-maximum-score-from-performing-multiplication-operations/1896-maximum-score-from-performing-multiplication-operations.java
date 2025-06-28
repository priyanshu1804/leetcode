class Solution {
    public int solve(int[] nums,int[] multipliers,int idx,int start,int end,int[][] dp){
        if(idx==multipliers.length){
            return 0;
        }
        if(dp[start][idx]!=-1){
            return dp[start][idx];
        }
        int pick=nums[start]*multipliers[idx]+solve(nums,multipliers,idx+1,start+1,end,dp);
        int pick1=nums[end]*multipliers[idx]+solve(nums,multipliers,idx+1,start,end-1,dp);
        return dp[start][idx]=Math.max(pick,pick1);
    }
    public int maximumScore(int[] nums, int[] multipliers) {
        int n=nums.length;
        int m=multipliers.length;
        int[][] dp=new int[m][m];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(nums,multipliers,0,0,n-1,dp);
    }
}