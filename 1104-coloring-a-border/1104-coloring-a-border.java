class Solution {
    public void dfs(int[][] grid,int i,int j,int col,boolean[][] vis,int color,int n,int m){
        if(i>n-1||i<0||j>m-1||j<0||grid[i][j]!=col||vis[i][j]){
            return;
        }
        vis[i][j]=true;
        boolean flag=false;
        if(i==0||j==0||j==m-1||i==n-1||grid[i+1][j]!=col||grid[i-1][j]!=col||grid[i][j-1]!=col||grid[i][j+1]!=col){
            flag=true;
        }
        dfs(grid,i+1,j,col,vis,color,n,m);
        dfs(grid,i-1,j,col,vis,color,n,m);
        dfs(grid,i,j+1,col,vis,color,n,m);
        dfs(grid,i,j-1,col,vis,color,n,m);
        if(flag){
            grid[i][j]=color;
        }
    }
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int n=grid.length;
        int m=grid[0].length;
        if(grid[row][col]==color){
            return grid;
        }
        boolean[][] vis=new boolean[n][m];
        dfs(grid,row,col,grid[row][col],vis,color,n,m);
        return grid;
    }
}