class Solution {
    public int solve(int i,List<Integer> nums,int target,int[][] dp){
        if(target==0){
            return 0;
        }
        if(target<0||i>=nums.size()){
            return Integer.MIN_VALUE;
        }
        if(dp[i][target]!=-1){
            return dp[i][target];
        }
        int pick=1+solve(i+1,nums,target-nums.get(i),dp);
        int notpick=solve(i+1,nums,target,dp);
        return dp[i][target]=Math.max(pick,notpick);
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n=nums.size();
        int[][] dp=new int[n+1][target+1];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        int ans=solve(0,nums,target,dp);
        if(ans<=0){
            return -1;
        }
        return ans;
    }
}