class Solution {
    public int solve(int idx,int val,int target,int[][] mat,int[][] dp){
        if(idx==mat.length){
            return Math.abs(val-target);
        }
        if(dp[idx][val]!=-1){
            return dp[idx][val];
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<mat[0].length;i++){
            ans=Math.min(ans,solve(idx+1,val+mat[idx][i],target,mat,dp));
        }
        return dp[idx][val]=ans;
    }
    public int minimizeTheDifference(int[][] mat, int target) {
        int n=mat.length;
        int[][] dp=new int[n][4901];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(0,0,target,mat,dp);
    }
}