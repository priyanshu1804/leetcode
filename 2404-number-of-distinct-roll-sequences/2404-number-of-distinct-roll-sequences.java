class Solution {
    int mod=1000000000+7;
    public int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
    public int solve(int i,int curr,int prev,int[][][] dp){
        if(i==1){
            return 1;
        }
        if(dp[i][curr][prev]!=-1){
            return dp[i][curr][prev];
        }
        int ans=0;
        for(int j=1;j<=6;j++){
            if(j!=prev&&j!=curr&&gcd(j,curr)==1){
                ans=(ans+solve(i-1,j,curr,dp))%mod;
            }
        }
        return dp[i][curr][prev]=ans;
    }
    public int distinctSequences(int n) {
        if(n==1){
            return 6;
        }
        int[][][] dp=new int[n][7][7];
        for(int[][] it:dp){
            for(int[] rows:it){
                Arrays.fill(rows,-1);
            }
        }
        int ans=0;
        for(int i=1;i<=6;i++){
            for(int j=1;j<=6;j++){
                if(i!=j&&gcd(i,j)==1){
                    ans=(ans+solve(n-1,i,j,dp))%mod;
                }
            }
        }
        return ans;
    }
}