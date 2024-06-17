class Solution {
    public int solve(int[][] score,int prev,int i,int[][] dp){
        if(i>=score.length){
            return 0;
        }
        if(dp[prev+1][i]!=-1){
            return dp[prev+1][i];
        }
        if(prev==-1||score[i][1]>=score[prev][1]){
            return dp[prev+1][i]=Math.max(solve(score,prev,i+1,dp),score[i][1]+solve(score,i,i+1,dp));
        }
        return dp[prev+1][i]=solve(score,prev,i+1,dp);
    }
    public int bestTeamScore(int[] scores, int[] ages) {
        int n=ages.length;
        int[][] score=new int[n][2];
        for(int i=0;i<n;i++){
            score[i][0]=ages[i];
            score[i][1]=scores[i];
        }
        int[][] dp=new int[n+1][n+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        Arrays.sort(score,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        return solve(score,-1,0,dp);
    }
}