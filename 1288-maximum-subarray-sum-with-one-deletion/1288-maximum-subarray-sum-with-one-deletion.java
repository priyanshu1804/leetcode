class Solution {
    int ans;
    public int solve(int i,int k,int[][] dp,int[] nums){
        if(i==0){
            return nums[0];
        }
        if(dp[i][k]!=-1){
            return dp[i][k];
        }
        dp[i][k]=Math.max(nums[i],nums[i]+solve(i-1,k,dp,nums));
        if(k==1){
            dp[i][k]=Math.max(dp[i][k],solve(i-1,k-1,dp,nums));
        }
        ans=Math.max(ans,dp[i][k]);
        return dp[i][k];
    }
    public int maximumSum(int[] arr) {
        int n=arr.length;
        int[][] dp=new int[arr.length][2];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        ans=arr[0];
        solve(n-1,1,dp,arr);
        return ans;
    }
}