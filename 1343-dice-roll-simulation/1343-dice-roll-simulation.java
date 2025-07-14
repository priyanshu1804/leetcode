class Solution {
    int mod=(int)1e9+7;
    public long solve(int i,int[] arr,int prev,int con,long[][][] dp){
        if(i==0){
            return 1;
        }
        if(dp[i][prev][con]!=-1){
            return dp[i][prev][con];
        }
        long sum=0;
        for(int j=1;j<=6;j++){
            if(j==prev){
                if(arr[j-1]>=con+1){
                    sum=(sum+solve(i-1,arr,j,con+1,dp))%mod;
                }
            }else{
                sum=(sum+solve(i-1,arr,j,1,dp))%mod;
            }
        }
        return dp[i][prev][con]=sum;
    }
    public int dieSimulator(int n, int[] rollMax){
        long[][][] dp=new long[n+1][7][16];
        for(long[][] mat:dp){
            for(long[] row:mat){
                Arrays.fill(row,-1);
            }
        }
        return (int)solve(n,rollMax,0,0,dp);
    }
}
