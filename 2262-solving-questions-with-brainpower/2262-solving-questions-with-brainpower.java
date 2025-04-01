class Solution {
    public long solve(int i,int[][] questions,long[] dp){
        if(i>=questions.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        long pick=questions[i][0]+solve(i+questions[i][1]+1,questions,dp);
        long notpick=solve(i+1,questions,dp);
        return dp[i]=Math.max(pick,notpick);
    }
    public long mostPoints(int[][] questions) {
        long[] dp=new long[questions.length];
        Arrays.fill(dp,-1);
        return solve(0,questions,dp);
    }
}