class Solution {
    int[][] op={{100,0},{75,25},{50,50},{25,75}};
    public double solve(int a,int b,double[][] dp){
        if(a==0){
            if(b==0){
                return 0.5;
            }
            return 1;
        }
        if(b==0){
            return 0;
        }
        if(dp[a][b]!=-1){
            return dp[a][b];
        }
        double ans=0;
        for(int i=0;i<4;i++){
            int a1=op[i][0];
            int b1=op[i][1];
            ans+=0.25*solve(Math.max(0,a-a1),Math.max(0,b-b1),dp);
        }
        return dp[a][b]=ans;
    }
    public double soupServings(int n) {
        if(n>=4800){
            return 1;
        }
        double[][] dp=new double[n+1][n+1];
        for(double[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(n,n,dp);
    }
}