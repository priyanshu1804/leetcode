class Solution {
    public int solve(int i,int j,int[] stones,int[][] dp,int sum){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int left=sum-stones[i]-solve(i+1,j,stones,dp,sum-stones[i]);
        int right=sum-stones[j]-solve(i,j-1,stones,dp,sum-stones[j]);
        return dp[i][j]=Math.max(left,right);
    }
    public int stoneGameVII(int[] stones) {
        int n=stones.length;
        int[][] dp=new int[n][n];
        int sum=0;
        for(int it:stones){
            sum+=it;
        }
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(0,n-1,stones,dp,sum);
    }
}