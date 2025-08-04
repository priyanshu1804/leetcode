class Solution {
    public int solve(int idx,int prev,String word,int n,int[][] dp){
        if(idx>=n){
            return 0;
        }
        if(dp[idx][prev]!=-1){
            return dp[idx][prev];
        }
        if(Math.abs(word.charAt(idx)-word.charAt(prev))<=1){
            return dp[idx][prev]=1+solve(idx+2,idx+1,word,n,dp);
        }else{
            return dp[idx][prev]=solve(idx+1,idx,word,n,dp);
        }
    }
    public int removeAlmostEqualCharacters(String word) {
        int n=word.length();
        int[][] dp=new int[n+1][n+1];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(1,0,word,n,dp);
    }
}