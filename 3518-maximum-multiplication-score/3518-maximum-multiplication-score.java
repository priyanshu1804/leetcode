class Solution {
    public long solve(int i,int j,int[] a,int[] b,Long[][] dp){
        if(i==4){
            return 0;
        }
        if(j>=b.length){
            return (long)-1e11+7;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        long pick=(long)a[i]*b[j]+solve(i+1,j+1,a,b,dp);
        long notpick=solve(i,j+1,a,b,dp);
        return dp[i][j]=Math.max(pick,notpick);
    }
    public long maxScore(int[] a, int[] b) {
        int n=a.length;
        int m=b.length;
        Long[][] dp=new Long[n+1][m+1];
        return solve(0,0,a,b,dp);
    }
}
