class Solution {
    public int solve1(char ch1, char ch2){
        int d=Math.abs(ch1-ch2);
        return Math.min(d,26-d);
    }
    public int solve(int i,int j,int k,int[][][] dp,String s){
        if(i>j){
            return 0;
        }
        if(i==j){
            return 1;
        }
        if(dp[i][j][k]!=-1){
            return dp[i][j][k];
        }
        int ans=0;
        if(s.charAt(i)==s.charAt(j)){
            ans=2+solve(i+1,j-1,k,dp,s);
        }else{
            ans=Math.max(solve(i+1,j,k,dp,s),solve(i,j-1,k,dp,s));
            int diff=solve1(s.charAt(i),s.charAt(j));
            if(k>=diff){
                ans=Math.max(ans,2+solve(i+1,j-1,k-diff,dp,s));
            }
        }
        return dp[i][j][k]=ans;
    }
    public int longestPalindromicSubsequence(String s, int k) {
        int[][][] dp=new int[s.length()+1][s.length()+1][k+1];
        for(int[][] row:dp){
            for(int[] col:row){
                Arrays.fill(col,-1);
            }
        }
        return solve(0,s.length()-1,k,dp,s);
    }
}