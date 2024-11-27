class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                dp[i][j]=j-i;
            }
        }
        int[] ans=new int[queries.length];
        int index=0;
        for(int[] it:queries){
            int x=it[0];
            int y=it[1];
            dp[x][y]=1;
            for(int i=y+1;i<n;i++){
                dp[x][i]=Math.min(dp[x][i],dp[x][y]+dp[y][i]);
            }
            for(int i=0;i<x;i++){
                for(int j=y;j<n;j++){
                    dp[i][j]=Math.min(dp[i][j],dp[i][x]+dp[x][y]+dp[y][j]);
                }
            }
            ans[index++]=dp[0][n-1];
        }
        return ans;
    }
}