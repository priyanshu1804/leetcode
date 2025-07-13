class Solution {
    public int dfs(int i,int j,int[][] matrix,int[][] dp){
        if(dp[i][j]>0){
            return dp[i][j];
        }
        int n=matrix.length;
        int m=matrix[0].length;
        int ans=1;
        int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
        for(int[] it:dir){
            int nextx=i+it[0];
            int nexty=j+it[1];
            if(nextx<0||nextx>=n||nexty<0||nexty>=m){
                continue;
            }
            if(matrix[nextx][nexty]<=matrix[i][j]){
                continue;
            }
            ans=Math.max(ans,dfs(nextx,nexty,matrix,dp)+1);
        }
        return dp[i][j]=ans;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        if(n==1&&m==1){
            return 1;
        }
        int max=0;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dp[i][j]==0){
                    max=Math.max(max,dfs(i,j,matrix,dp));
                }
            }
        }
        return max;
    }
}