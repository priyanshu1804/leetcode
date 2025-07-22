class Solution {
    public int dfs(int[][] grid,int r,int c){
        if(r==3){
            return 0;
        }
        if(c==3){
            return dfs(grid,r+1,0);   
        }
        int ans=Integer.MAX_VALUE;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(grid[i][j]>0){
                        grid[i][j]--;
                        int dist=Math.abs(i-r)+Math.abs(j-c)+dfs(grid,r,c+1);
                        ans=Math.min(ans,dist);
                        grid[i][j]++;
                    }
                }
            }
        return ans;
    }
    public int minimumMoves(int[][] grid) {
        return dfs(grid,0,0);
    }
}