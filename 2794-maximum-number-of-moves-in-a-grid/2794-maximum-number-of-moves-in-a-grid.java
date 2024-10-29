class Solution {
    public int solve(int n,int m,int i,int j,int[][] grid,int[][] dp){
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down=0;
        int up=0;
        int right=0;
        if(i+1<n&&j+1<m&&grid[i][j]<grid[i+1][j+1]){
            down=1+solve(n,m,i+1,j+1,grid,dp);
        }
        if(i-1>=0&&j+1<m&&grid[i][j]<grid[i-1][j+1]){
            up=1+solve(n,m,i-1,j+1,grid,dp);
        }
        if(j+1<m&&grid[i][j]<grid[i][j+1]){
            right=1+solve(n,m,i,j+1,grid,dp);
        }
        return dp[i][j]=Math.max(down,Math.max(up,right));
    }
    public int maxMoves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,solve(n,m,i,0,grid,dp));
        }
        return max;
    }
}