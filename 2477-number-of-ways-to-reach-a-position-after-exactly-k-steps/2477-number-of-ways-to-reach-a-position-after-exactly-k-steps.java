class Solution {
    int dp[][];
    int mod=(int)1e9+7;
    public int solve(int s,int e,int k){
        if(k==0){
            if(s==e){
                return 1;
            }
            return 0;
        }
        if(dp[s+2001][k]!=-1){
            return dp[s+2001][k];
        }
        int x=solve(s+1,e,k-1);
        int y=solve(s-1,e,k-1);
        return dp[s+2001][k]=(x+y)%mod;
    }
    public int numberOfWays(int startPos, int endPos, int k) {
        dp=new int[4001][1001];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(startPos,endPos,k);
    }
}