class Solution {
    public int solve(int curr,int days,int n,int k,int[][] arr,int[][] arr1,int[][] dp){
        if(days==k){
            return 0;
        }
        if(dp[curr+1][days]!=-1){
            return dp[curr+1][days];
        }
        int max=curr==-1?0:arr[days][curr]+solve(curr,days+1,n,k,arr,arr1,dp);
        for(int i=0;i<n;i++){
            if(curr!=i){
                max=Math.max(max,curr==-1?solve(i,days,n,k,arr,arr1,dp):arr1[curr][i]+solve(i,days+1,n,k,arr,arr1,dp));
            }
        }
        dp[curr+1][days]=max;
        return max;
    }
    public int maxScore(int n, int k, int[][] stayScore, int[][] travelScore) {
        int[][] dp=new int[n+1][k+1];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return solve(-1,0,n,k,stayScore,travelScore,dp);
    }
}