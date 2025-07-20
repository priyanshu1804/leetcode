class Solution {
    public int solve(int i,int j,int[][] grid,int move,int[][][] dp){
        int n=grid.length;
        int m=grid[0].length;
        if(dp[i][j][move]!=-1){
            return dp[i][j][move];
        }
        int ans=0;
        int x=(move==1)?i+1:i-1;
        if(x>=0&&x<n&&j-1>=0&&j+1<m&&grid[x][j]==1&&grid[x][j-1]==1&&grid[x][j+1]==1){
            ans+=1+Math.min(solve(x,j-1,grid,move,dp),solve(x,j+1,grid,move,dp));
        }
        return dp[i][j][move]=ans;
    }
    public int countPyramids(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][][] dp=new int[n][m][2];
        for(int[][] it:dp){
            for(int[] rows:it){
                Arrays.fill(rows,-1);
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    ans+=(solve(i,j,grid,0,dp)+solve(i,j,grid,1,dp));
                }
            }
        }
        return ans;
    }
}