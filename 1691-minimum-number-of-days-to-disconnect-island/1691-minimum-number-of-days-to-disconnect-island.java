class Solution {
    int[] row={0,0,1,-1};
    int[] col={-1,1,0,0};
    public int solve(int[][] grid){
        boolean[][] vis=new boolean[grid.length][grid[0].length];
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1&&vis[i][j]==false){
                    count++;
                    dfs(grid,i,j,vis);
                }
            }
        }
        return count;
    }
    public void dfs(int[][] grid,int i,int j,boolean[][] vis){
        vis[i][j]=true;
        for(int k=0;k<4;k++){
            int nr=row[k]+i;
            int nc=col[k]+j;
            if(nr>=0&&nr<grid.length&&nc>=0&&nc<grid[0].length&&grid[nr][nc]==1&&!vis[nr][nc]) {
                dfs(grid,nr,nc,vis);
            }
        }
    }
    public int minDays(int[][] grid) {
        if(solve(grid)!=1){
            return 0;
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    grid[i][j]=0;
                    if(solve(grid)!=1){
                        return 1;
                    }
                    grid[i][j]=1;
                }
            }
        }
        return 2;
    }
}