class Solution {
    public long solve(String s,int idx,int prev,int len,int n,long[][][] dp){
        if(len==3){
            return 1;
        }
        if(idx==n){
            return 0;
        }
        if(dp[idx][prev][len]!=-1){
            return dp[idx][prev][len];
        }
        long ans=solve(s,idx+1,prev,len,n,dp);
        if(prev!=(s.charAt(idx)-'0')){
            ans+=solve(s,idx+1,s.charAt(idx)-'0',len+1,n,dp);
        }
        return dp[idx][prev][len]=ans;
    }
    public long numberOfWays(String s) {
        int n=s.length();
        long[][][] dp=new long[n][3][4];
        for(long[][] it:dp){
            for(long[] rows:it){
                Arrays.fill(rows,-1);
            }
        }
        return solve(s,0,2,0,n,dp);
    }
}