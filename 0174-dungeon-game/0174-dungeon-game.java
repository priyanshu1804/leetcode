class Solution {
    public int solve(int i,int j,int[][] dungeon,int[][] dp){
        int n=dungeon.length;
        int m=dungeon[0].length;
        if(i==n||j==m){
            return (int)1e9;
        }
        if(i==n-1&&j==m-1){
            return (dungeon[i][j]<=0)?-dungeon[i][j]+1:1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int right=solve(i,j+1,dungeon,dp);
        int down=solve(i+1,j,dungeon,dp);
        int min=Math.min(right,down)-dungeon[i][j];
        return dp[i][j]=(min<=0)?1:min;
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int n=dungeon.length;
        int m=dungeon[0].length;
        int[][] dp=new int[n][m];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(0,0,dungeon,dp);
    }
}