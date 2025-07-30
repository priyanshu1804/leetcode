class Solution {
    int[][] dirs={{-1,-2},{1,2},{-1,2},{1,-2},{2,1},{-2,-1},{2,-1},{-2,1}};
    public boolean dfs(int[][] grid,int i,int j,int curr,int n){
        if(curr==n*n-1){
            return true;
        }
        curr++;
        for(int k=0;k<8;k++){
            int nrow=i+dirs[k][0];
            int ncol=j+dirs[k][1];
            if(nrow<0||ncol<0||nrow>=n||ncol>=n){
                continue;
            }
            if(grid[nrow][ncol]==curr) {
                return dfs(grid,nrow,ncol,curr,n);
            }
        }
        return false;
    }

    public boolean checkValidGrid(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]!=0){
            return false;
        }
        return dfs(grid,0,0,0,n);
    }
}