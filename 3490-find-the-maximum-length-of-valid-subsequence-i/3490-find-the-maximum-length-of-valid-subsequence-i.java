class Solution {
    public int solve(int i,int prev,int parity,int[] nums,int[][][] dp){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i][prev+1][parity]!=-1){
            return dp[i][prev+1][parity];
        }
        if(prev==-1||(prev+nums[i])%2==parity){
            return dp[i][prev+1][parity]=Math.max(1+solve(i+1,nums[i]%2,parity,nums,dp),solve(i+1,prev,parity,nums,dp));
        }else{
            return dp[i][prev+1][parity]=solve(i+1,prev,parity,nums,dp);
        }
    }
    public int maximumLength(int[] nums){
        int n=nums.length;
        int[][][] dp=new int[n][3][2];
        for(int[][] it:dp){
            for(int[] rows:it){
                Arrays.fill(rows,-1);
            }
        }
        return Math.max(solve(0,-1,0,nums,dp),solve(0,-1,1,nums,dp));
    }
}