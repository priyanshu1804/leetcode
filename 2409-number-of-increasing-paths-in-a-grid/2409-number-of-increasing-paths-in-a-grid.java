class Solution {
    int mod=(int)Math.pow(10,9)+7;
    public int dfs(int i,int j,int[][] grid,int[][] dp,int parent){
        int n=grid.length;
        int m=grid[0].length;
        if(i<0||i>=n||j<0||j>=m||grid[i][j]<=parent){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down=dfs(i+1,j,grid,dp,grid[i][j])%mod;
        int up=dfs(i-1,j,grid,dp,grid[i][j])%mod;
        int right=dfs(i,j+1,grid,dp,grid[i][j])%mod;
        int left=dfs(i,j-1,grid,dp,grid[i][j])%mod;
        return dp[i][j]=(down+up+right+left+1)%mod;
    }
    public int countPaths(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dp[i][j]==-1){
                    dfs(i,j,grid,dp,-1);
                }
            }
        }
        long sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sum=(sum+dp[i][j])%mod;
            }
        }
        return (int)sum;
    }
}