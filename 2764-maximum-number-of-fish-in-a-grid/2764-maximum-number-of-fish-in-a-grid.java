class Solution {
    public int dfs(int[][] grid,boolean[][] vis,int i,int j){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==0||vis[i][j]){
            return 0;
        }
        vis[i][j]=true;
        return (grid[i][j]+dfs(grid,vis,i,j+1)+dfs(grid,vis,i,j-1)+dfs(grid,vis,i+1,j)+dfs(grid,vis,i-1,j));
    }
    public int findMaxFish(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int max=0;
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]>0&&!vis[i][j]){
                    max=Math.max(max,dfs(grid,vis,i,j));
                }
            }
        }
        return max;
    }
}