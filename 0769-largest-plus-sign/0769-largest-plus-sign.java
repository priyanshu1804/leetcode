class Solution {
    int[][] dir={
        {0,-1},
        {0,1},  
        {1,0}, 
        {-1,0} 
    };
    public int solve(int i,int j,int k,int[][] grid,int[][][] dp){
        int n=grid.length;
        if(dp[i][j][k]!=-1){
            return dp[i][j][k];
        }
        int ni=i+dir[k][0];
        int nj=j+dir[k][1];
        if(ni<0||nj<0||ni>=n||nj>=n||grid[ni][nj]==0){
            return 0;
        }
        return dp[i][j][k]=1+solve(ni,nj,k,grid,dp);
    }
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] grid=new int[n][n];
        for(int[] it:grid){
            Arrays.fill(it,1);
        }
        int[][][] dp=new int[n][n][4];
        for(int[][] it:dp){
            for(int[] row:it){
                Arrays.fill(row,-1);
            }
        }
        for(int i=0;i<mines.length;i++){
            grid[mines[i][0]][mines[i][1]]=0;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    ans=Math.max(ans,1+Math.min(Math.min(solve(i,j,0,grid,dp),solve(i,j,1,grid,dp)),Math.min(solve(i,j,2,grid,dp),solve(i,j,3,grid,dp))));
                }
            }
        }
        return ans;
    }
}