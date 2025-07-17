class Solution {
    private int dfs(int[][] grid,int i,int j){
        if(i==grid.length-1&&j==grid[0].length-1){
            return 1;
        }
        if(i==grid.length||j==grid[0].length||grid[i][j]==0){
            return 0;
        }
        grid[i][j]=0;
        if(dfs(grid,i+1,j)==1){
            return 1;
        }
        return dfs(grid,i,j+1);
    }
    public boolean isPossibleToCutPath(int[][] grid) {
        int first=dfs(grid,0,0);
        grid[0][0]=1;
        int second=dfs(grid,0,0);
        return second>=1?false:true;
    }
}