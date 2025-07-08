class Solution {
    public int solve(int i,int k,int last,int[][] events,int[][] dp){
        if(i>=events.length||k==0){
            return 0;
        }
        if(last>=events[i][0]){
            return solve(i+1,k,last,events,dp);
        }
        if(dp[i][k]!=-1){
            return dp[i][k];
        }
        int pick=events[i][2]+solve(i+1,k-1,events[i][1],events,dp);
        int notpick=solve(i+1,k,last,events,dp);
        return dp[i][k]=Math.max(pick,notpick);
    }
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events,(e1,e2)->(e1[0]==e2[0]?e1[1]-e2[1]:e1[0]-e2[0]));
        int[][] dp=new int[events.length][k+1];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(0,k,0,events,dp);
    }
}