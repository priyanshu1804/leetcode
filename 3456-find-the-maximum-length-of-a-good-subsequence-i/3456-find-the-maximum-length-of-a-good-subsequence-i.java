class Solution {
    public int solve(int i,int prev,int k,int[] nums,int[][][] dp,int n){
        if(i==n){
            return 0;
        }
        if(dp[i][prev+1][k]!=-1){
            return dp[i][prev+1][k];
        }
        int max=0;
        if(prev==-1||nums[i]==nums[prev]){
            max=Math.max(max,1+solve(i+1,i,k,nums,dp,n));
        }else if(k>0){
            max=Math.max(max,1+solve(i+1,i,k-1,nums,dp,n));
        }
        max=Math.max(max,solve(i+1,prev,k,nums,dp,n));
        return dp[i][prev+1][k]=max;
    }
    public int maximumLength(int[] nums,int k){
        int n=nums.length;
        int[][][] dp=new int[n][n+1][k+1];
        for(int[][] it:dp){
            for(int[] row:it){
                Arrays.fill(row,-1);
            }
        }
        return solve(0,-1,k,nums,dp,n);
    }
}
