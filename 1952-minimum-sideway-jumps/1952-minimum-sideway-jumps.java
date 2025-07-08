class Solution {
    public int solve(int i,int j,int[] obstacles,int[][] dp){
        if(i==obstacles.length-1){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(obstacles[i+1]!=j){
            return solve(i+1,j,obstacles,dp);
        }
        int min=Integer.MAX_VALUE;
        for(int k=1;k<=3;k++){
            if(k!=j&&obstacles[i]!=k){
                min=Math.min(min,1+solve(i+1,k,obstacles,dp));
            }
        }
        return dp[i][j]=min;
    }
    public int minSideJumps(int[] obstacles) {
        int n=obstacles.length;
        int[][] dp=new int[n][4];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(0,2,obstacles,dp);
    }
}