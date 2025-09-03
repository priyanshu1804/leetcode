class Solution {
    int mod=(int)1e9+7;
    public int solve(int i,int j,boolean flag,int[][] dp,int[][] grid,int n,int m){
        if(i>=n||j>=m){
            return 0;
        }
        if(i==n-1&&j==m-1){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        if(grid[i][j]==1){
            if(flag){
                return solve(i+1,j,!flag,dp,grid,n,m);
            }else{
                return solve(i,j+1,!flag,dp,grid,n,m);
            }
        }else{
            ans+=solve(i,j+1,true,dp,grid,n,m)+solve(i+1,j,false,dp,grid,n,m);
        }
        return dp[i][j]=ans%mod;
    }
    public int uniquePaths(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(0,0,false,dp,grid,n,m);
    }
}