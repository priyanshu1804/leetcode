class Solution {
    public int solve(int[] pre,int i,int j,int[][] dp){
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int max=Integer.MIN_VALUE;
        for(int k=i;k<=j-1;k++){
            int left =pre[k]-pre[i-1];
            int right=pre[j]-pre[k];
            if(left>right){
                max=Math.max(max,right+solve(pre,k+1,j,dp));
            }else if(left<right){
                max=Math.max(max,left+solve(pre,i,k,dp));
            }else if(left==right){
                max=Math.max(max,left+solve(pre,i,k,dp));
                max=Math.max(max,right+solve(pre,k+1,j,dp));
            }
        }
        return dp[i][j]=max;
    }
    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;
        int[][] dp=new int[n+1][n+1];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        int[] pre=new int[n+1];
        for(int i=0;i<n;i++){
            pre[i+1]=pre[i]+stoneValue[i];
        }
        return solve(pre,1,n,dp);
    }
}